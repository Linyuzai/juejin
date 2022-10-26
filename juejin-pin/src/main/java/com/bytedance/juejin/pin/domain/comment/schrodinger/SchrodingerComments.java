package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.comment.*;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * 薛定谔的评论集合
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerComments extends CommentsImpl implements Comments {

    /**
     * 沸点ID
     */
    protected String pinId;

    /**
     * 评论ID
     */
    protected String commentId;

    /**
     * 领域上下文
     */
    protected DomainContext context;

    @Override
    public Pin getPin() {
        if (super.getPin() == null) {
            PinRepository pinRepository = getContext().get(PinRepository.class);
            this.pin = pinRepository.get(getPinId());
            if (this.pin == null) {
                throw new JuejinException("Pin not found: " + pinId);
            }
        }
        return super.getPin();
    }

    @Override
    public Comment getComment() {
        if (getCommentId() == null) {
            return null;
        }
        if (super.getComment() == null) {
            CommentRepository commentRepository = getContext().get(CommentRepository.class);
            String commentId = getCommentId();
            this.comment = commentRepository.get(getCommentId());
            if (this.comment == null) {
                throw new JuejinException("Comment not found: " + commentId);
            }
        }
        return super.getComment();
    }

    /**
     * 获得某条评论
     */
    @Override
    public Comment get(String commentId) {
        //查询本身缓存
        Comment exist = super.get(commentId);
        if (exist == null) {
            //如果没有则从存储中查询
            CommentRepository commentRepository = getContext().get(CommentRepository.class);
            Comment comment = commentRepository.get(commentId);
            if (comment == null) {
                throw new JuejinException("Comment not found: " + commentId);
            }
            //放入缓存
            getComments().put(commentId, comment);
            return comment;
        }
        return exist;
    }

    /**
     * 获得沸点或评论的评论数
     */
    @Override
    public long count() {
        //如果存在 commentId 是评论的评论数，否则是沸点的评论数
        LambdaConditions conditions = new LambdaConditions();
        conditions.equal(this::getPinId, getPinId());
        String commentId = getCommentId();
        if (commentId != null) {
            conditions.equal(this::getCommentId, commentId);
        }
        CommentRepository commentRepository = getContext().get(CommentRepository.class);
        return commentRepository.count(conditions);
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerComments, Builder> {

        @NotEmpty
        protected String pinId;

        protected String commentId;

        public Builder pinId(String pinId) {
            this.pinId = pinId;
            return this;
        }

        public Builder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        @Override
        public SchrodingerComments doBuild() {
            return new SchrodingerComments(pinId, commentId, context);
        }
    }
}
