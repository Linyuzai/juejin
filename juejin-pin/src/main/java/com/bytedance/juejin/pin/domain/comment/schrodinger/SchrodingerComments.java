package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.Comments;

import java.util.List;

public abstract class SchrodingerComments extends SchrodingerDomainCollection<Comment> implements Comments {

    @Override
    protected Class<Comment> getDomainType() {
        return Comment.class;
    }

    @Override
    protected Class<? extends DomainRepository<Comment>> getDomainRepositoryType() {
        return CommentRepository.class;
    }

    @Override
    public List<Comment> getNewestList(int count) {
        CommentRepository commentRepository = context.get(CommentRepository.class);
        Conditions conditions = obtainConditions().lambda()
                .isNull(Comment::getId)
                .orderBy(Comment::getCreateTime, true, false)
                .limit(count);
        return commentRepository.list(conditions);
    }
}
