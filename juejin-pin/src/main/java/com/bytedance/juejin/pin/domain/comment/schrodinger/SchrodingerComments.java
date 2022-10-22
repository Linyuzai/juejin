package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.comment.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * 薛定谔的评论集合
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerComments extends CommentsImpl implements Comments {

    /**
     * 沸点ID
     */
    protected String pinId;

    protected CommentRepository commentRepository;

    protected CommentSearcher commentSearcher;

    /**
     * 获得某条评论
     */
    @Override
    public Comment get(String commentId) {
        Comment exist = super.get(commentId);
        if (exist == null) {
            Comment comment = getCommentRepository().get(commentId);
            if (comment == null) {
                throw new JuejinException("Comment not found: " + commentId);
            }
            getComments().put(commentId, comment);
            return comment;
        }
        return exist;
    }

    /**
     * 获得沸点的评论数
     */
    @Override
    public long count() {
        return commentSearcher.count(pinId);
    }

    public static class Builder {

        protected String pinId;

        protected CommentRepository commentRepository;

        protected CommentSearcher commentSearcher;

        public Builder pinId(String pinId) {
            this.pinId = pinId;
            return this;
        }

        public Builder commentRepository(CommentRepository commentRepository) {
            this.commentRepository = commentRepository;
            return this;
        }

        public Builder commentSearcher(CommentSearcher commentSearcher) {
            this.commentSearcher = commentSearcher;
            return this;
        }

        public SchrodingerComments build() {
            if (!StringUtils.hasText(pinId)) {
                throw new IllegalArgumentException("Pin id required");
            }
            if (commentRepository == null) {
                throw new IllegalArgumentException("CommentRepository required");
            }
            if (commentSearcher == null) {
                throw new IllegalArgumentException("CommentSearcher required");
            }
            return new SchrodingerComments(pinId, commentRepository, commentSearcher);
        }
    }
}
