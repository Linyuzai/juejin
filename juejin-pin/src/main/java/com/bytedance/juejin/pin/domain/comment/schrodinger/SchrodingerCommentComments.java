package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.Comments;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 薛定谔的评论集合
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerCommentComments extends SchrodingerComments implements Comments {

    protected SchrodingerCommentComments(String commentId, DomainContext context) {
        this.ownerId = commentId;
        this.context = context;
    }

    @Override
    protected void onConditionsObtain(Conditions conditions, String id) {
        conditions.lambda().equal(Comment::getId, id);
    }


    @Override
    protected Class<?> getOwnerType() {
        return Comment.class;
    }

    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return CommentRepository.class;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerCommentComments, Builder> {

        @NotNull
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
