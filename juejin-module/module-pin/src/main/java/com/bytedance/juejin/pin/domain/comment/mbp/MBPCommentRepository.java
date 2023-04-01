package com.bytedance.juejin.pin.domain.comment.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentInstantiator;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.like.LikeInstantiator;
import com.bytedance.juejin.pin.domain.pin.PinInstantiator;
import com.bytedance.juejin.pin.domain.user.UserInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 基于 MyBatis-Plus 的评论存储实现
 */
@Repository
@SuppressWarnings("unchecked")
public class MBPCommentRepository<P extends CommentPO> extends MBPDomainRepository<Comment, P> implements CommentRepository {

    /**
     * 评论 Mapper
     */
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 领域上下文
     */
    @Autowired
    private DomainContext context;

    /**
     * 领域校验器
     */
    @Autowired
    private DomainValidator validator;

    /**
     * 沸点实例化器
     */
    @Autowired
    private PinInstantiator pinInstantiator;

    /**
     * 评论实例化器
     */
    @Autowired
    private CommentInstantiator commentInstantiator;

    /**
     * 用户实例化器
     */
    @Autowired
    private UserInstantiator userInstantiator;

    /**
     * 点赞实例化器
     */
    @Autowired
    private LikeInstantiator likeInstantiator;

    /**
     * 领域模型转数据模型
     */
    @Override
    public P do2po(Comment comment) {
        CommentPO po = new CommentPO();
        po.setId(comment.getId());
        PinOrComment owner = comment.getOwner();
        if (owner.isPin()) {
            po.setPinId(owner.asPin().getId());
        }
        if (owner.isComment()) {
            po.setCommentId(owner.asComment().getId());
            po.setPinId(owner.asComment().getPin().getId());
        }
        po.setContent(comment.getContent());
        po.setUserId(comment.getUser().getId());
        po.setCreateTime(new Date(comment.getCreateTime()));
        return (P) po;
    }

    /**
     * 数据模型转领域模型
     */
    @Override
    public Comment po2do(CommentPO po) {
        PinOrComment owner;
        if (po.getCommentId() == null) {
            owner = pinInstantiator.newSchrodingerBuilder()
                    .id(po.getPinId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else {
            owner = commentInstantiator.newSchrodingerBuilder()
                    .id(po.getCommentId())
                    .context(context)
                    .validator(validator)
                    .build();
        }
        return commentInstantiator.newBuilder()
                .id(po.getId())
                .owner(owner)
                .content(po.getContent())
                .user(userInstantiator.newSchrodingerBuilder()
                        .id(po.getUserId())
                        .context(context)
                        .validator(validator)
                        .build())
                .comments(commentInstantiator.newSchrodingerCollectionBuilderOwnedComment()
                        .commentId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .likes(likeInstantiator.newSchrodingerCollectionBuilderOwnedComment()
                        .commentId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .createTime(po.getCreateTime().getTime())
                .validator(validator)
                .build();
    }

    @Override
    public Class<P> getFetchClass() {
        return (Class<P>) CommentPO.class;
    }

    @Override
    public BaseMapper<P> getBaseMapper() {
        return (BaseMapper<P>) commentMapper;
    }
}
