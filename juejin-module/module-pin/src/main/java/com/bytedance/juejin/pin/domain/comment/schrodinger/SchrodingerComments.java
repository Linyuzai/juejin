package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.Comments;

import java.util.List;

/**
 * 评论集合的薛定谔模型
 */
public abstract class SchrodingerComments extends SchrodingerDomainCollection<Comment> implements Comments {

    @Override
    protected Class<? extends Comment> getDomainType() {
        return Comment.class;
    }

    @Override
    protected Class<? extends DomainRepository<? extends Comment>> getDomainRepositoryType() {
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
