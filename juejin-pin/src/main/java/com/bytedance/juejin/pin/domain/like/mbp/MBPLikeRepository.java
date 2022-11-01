package com.bytedance.juejin.pin.domain.like.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.like.LikeImpl;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MBPLikeRepository extends MBPDomainRepository<Like, LikePO> implements LikeRepository {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Override
    public LikePO do2po(Like like) {
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
        return po;
    }

    @Override
    public Like po2do(LikePO po) {
        PinOrComment owner;
        if (po.getPinId() != null) {
            owner = new SchrodingerPin.Builder()
                    .id(po.getPinId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else if (po.getCommentId() != null) {
            owner = new SchrodingerComment.Builder()
                    .id(po.getCommentId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else {
            owner = null;
        }
        return new LikeImpl.Builder()
                .id(po.getId())
                .owner(owner)
                .user(new SchrodingerUser.Builder()
                        .id(po.getUserId())
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    public Class<LikePO> getFetchClass() {
        return LikePO.class;
    }

    @Override
    public BaseMapper<LikePO> getBaseMapper() {
        return likeMapper;
    }
}
