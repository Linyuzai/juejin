package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.like.Likes;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerCommentLikes extends SchrodingerLikes implements Likes {

    protected SchrodingerCommentLikes(String commentId, DomainContext context) {
        this.ownerId = commentId;
        this.context = context;
    }

    @Override
    protected Conditions onConditionsObtain(Conditions conditions, String id) {
        return conditions.lambda().equal(Comment::getId, id);
    }

    @Override
    protected Class<?> getOwnerType() {
        return Comment.class;
    }

    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return CommentRepository.class;
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
