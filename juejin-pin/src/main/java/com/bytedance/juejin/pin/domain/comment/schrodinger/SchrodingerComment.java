package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerComment implements DomainProxy<Comment> {

    protected final String id;

    protected final DomainContext context;

    protected Comment comment;

    @Override
    public Comment getTarget() {
        if (this.comment == null) {
            CommentRepository commentRepository = context.get(CommentRepository.class);
            Comment comment = commentRepository.get(id);
            if (comment == null) {
                throw new JuejinNotFoundException(Comment.class, id);
            }
            this.comment = comment;
        }
        return this.comment;
    }

    public static class Builder extends ContextDomainBuilder<Comment, Builder> {

        @NotEmpty
        protected String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        protected Comment doBuild() {
            return proxy(Comment.class, new SchrodingerComment(id, context));
        }
    }
}
