package com.bytedance.juejin.pin.domain.comment.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentImpl;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerCommentComments;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerCommentLikes;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 基于 MyBatis-Plus 的评论存储实现
 */
@Repository
public class MBPCommentRepository extends MBPDomainRepository<Comment, CommentPO> implements CommentRepository {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Override
    public CommentPO do2po(Comment comment) {
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
        return po;
    }

    @Override
    public Comment po2do(CommentPO po) {
        PinOrComment owner;
        if (po.getCommentId() == null) {
            owner = new SchrodingerPin.Builder()
                    .id(po.getPinId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else {
            owner = new SchrodingerComment.Builder()
                    .id(po.getCommentId())
                    .context(context)
                    .validator(validator)
                    .build();
        }
        return new CommentImpl.Builder()
                .id(po.getId())
                .owner(owner)
                .content(po.getContent())
                .user(new SchrodingerUser.Builder()
                        .id(po.getUserId())
                        .context(context)
                        .validator(validator)
                        .build())
                .comments(new SchrodingerCommentComments.Builder()
                        .commentId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .likes(new SchrodingerCommentLikes.Builder()
                        .commentId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .createTime(po.getCreateTime().getTime())
                .validator(validator)
                .build();
    }

    @Override
    public Class<CommentPO> getFetchClass() {
        return CommentPO.class;
    }

    @Override
    public BaseMapper<CommentPO> getBaseMapper() {
        return commentMapper;
    }
}
