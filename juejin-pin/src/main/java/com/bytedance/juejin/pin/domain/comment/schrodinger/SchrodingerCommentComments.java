package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.Comments;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * 薛定谔的评论集合
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerCommentComments extends SchrodingerComments implements Comments {

    /**
     * 评论ID
     */
    protected String commentId;

    protected SchrodingerCommentComments(String commentId, DomainContext context) {
        this.commentId = commentId;
        this.context = context;
    }

    @Override
    public Object doGetOwner() {
        CommentRepository commentRepository = context.get(CommentRepository.class);
        Comment comment = commentRepository.get(commentId);
        if (comment == null) {
            throw new JuejinNotFoundException(Comment.class, commentId);
        }
        return comment;
    }

    @Override
    protected Conditions obtainConditions() {
        LambdaConditions conditions = new LambdaConditions();
        conditions.equal(this::getCommentId, commentId);
        return conditions;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerCommentComments, Builder> {

        @NotEmpty
        protected String commentId;

        public Builder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        @Override
        protected SchrodingerCommentComments doBuild() {
            return new SchrodingerCommentComments(commentId, context);
        }
    }
}
