package com.bytedance.juejin.pin.domain.like.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.CommentInstantiator;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.like.LikeInstantiator;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import com.bytedance.juejin.pin.domain.pin.PinInstantiator;
import com.bytedance.juejin.pin.domain.user.UserInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 基于 MyBatis-Plus 的点赞存储
 *
 * @param <P>
 */
@Repository
@SuppressWarnings("unchecked")
public class MBPLikeRepository<P extends LikePO> extends MBPDomainRepository<Like, P> implements LikeRepository {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Autowired
    private PinInstantiator pinInstantiator;

    @Autowired
    private CommentInstantiator commentInstantiator;

    @Autowired
    private LikeInstantiator likeInstantiator;

    @Autowired
    private UserInstantiator userInstantiator;

    @Override
    public P do2po(Like like) {
        LikePO po = new LikePO();
        po.setId(like.getId());
        PinOrComment owner = like.getOwner();
        if (owner.isPin()) {
            po.setPinId(owner.getId());
        }
        if (owner.isComment()) {
            po.setCommentId(owner.getId());
        }
        po.setUserId(like.getUser().getId());
        return (P) po;
    }

    @Override
    public Like po2do(LikePO po) {
        PinOrComment owner;
        if (po.getPinId() != null) {
            owner = pinInstantiator.newSchrodingerBuilder()
                    .id(po.getPinId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else if (po.getCommentId() != null) {
            owner = commentInstantiator.newSchrodingerBuilder()
                    .id(po.getCommentId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else {
            owner = null;
        }
        return likeInstantiator.newBuilder()
                .id(po.getId())
                .owner(owner)
                .user(userInstantiator.newSchrodingerBuilder()
                        .id(po.getUserId())
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    public Class<P> getFetchClass() {
        return (Class<P>) LikePO.class;
    }

    @Override
    public BaseMapper<P> getBaseMapper() {
        return (BaseMapper<P>) likeMapper;
    }
}
