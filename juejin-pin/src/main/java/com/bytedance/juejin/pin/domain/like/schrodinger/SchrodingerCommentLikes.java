package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.like.Likes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerCommentLikes extends SchrodingerLikes implements Likes {

    protected String commentId;

    protected SchrodingerCommentLikes(String commentId, DomainContext context) {
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


    public static class Builder extends ContextDomainBuilder<SchrodingerCommentLikes, Builder> {

        @NotNull
        protected String commentId;

        public Builder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        @Override
        protected SchrodingerCommentLikes doBuild() {
            return new SchrodingerCommentLikes(commentId, context);
        }
    }
}
