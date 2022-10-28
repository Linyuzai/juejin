package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.Comments;

public abstract class SchrodingerComments extends SchrodingerDomainCollection<Comment> implements Comments {

    @Override
    protected Class<Comment> getDomainType() {
        return Comment.class;
    }

    @Override
    protected Class<? extends DomainRepository<Comment>> getDomainRepositoryType() {
        return CommentRepository.class;
    }
}
