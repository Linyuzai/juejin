package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainProxy;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerComment extends SchrodingerDomainProxy<Comment> {

    protected SchrodingerComment(String id, DomainContext context) {
        super(id, context);
    }

    @Override
    protected Class<Comment> getDomainType() {
        return Comment.class;
    }

    @Override
    protected Class<? extends DomainRepository<Comment>> getDomainRepositoryType() {
        return CommentRepository.class;
    }

    public static class Builder extends SchrodingerDomainProxy.Builder<Comment, Builder> {

        @Override
        protected Class<Comment> getDomainType() {
            return Comment.class;
        }

        @Override
        protected DomainProxy<Comment> getDomainProxy() {
            return new SchrodingerComment(id, context);
        }
    }
}
