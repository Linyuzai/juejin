package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinIdRequiredException;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.Comments;
import com.bytedance.juejin.pin.domain.comment.CommentsImpl;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

/**
 * 薛定谔的评论集合
 */
@Getter
public abstract class SchrodingerComments extends CommentsImpl implements Comments {

    /**
     * 领域上下文
     */
    protected DomainContext context;

    @Override
    public Comment doGet(String id) {
        if (!StringUtils.hasText(id)) {
            throw new JuejinIdRequiredException(Comment.class);
        }
        CommentRepository commentRepository = context.get(CommentRepository.class);
        Comment comment = commentRepository.get(id);
        if (comment == null) {
            return super.doGet(id);
        }
        return comment;
    }

    @Override
    public Stream<Comment> stream() {
        CommentRepository commentRepository = context.get(CommentRepository.class);
        return commentRepository.stream(obtainConditions());
    }

    /**
     * 获得沸点的评论数
     */
    @Override
    public long count() {
        CommentRepository commentRepository = context.get(CommentRepository.class);
        return commentRepository.count(obtainConditions());
    }

    protected abstract Conditions obtainConditions();
}
