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

    /**
     * 评论ID
     */
    protected String commentId;

    /**
     * 评论存储
     */
    protected CommentRepository commentRepository;

    /**
     * 获得某条评论
     */
    @Override
    public Comment get(String commentId) {
        //查询本身缓存
        Comment exist = super.get(commentId);
        if (exist == null) {
            //如果没有则从存储中查询
            Comment comment = getCommentRepository().get(commentId);
            if (comment == null) {
                throw new JuejinException("Comment not found: " + commentId);
            }
            //放入缓存
            getComments().put(commentId, comment);
            return comment;
        }
        return exist;
    }

    /**
     * 获得沸点或评论的评论数
     */
    @Override
    public long count() {
        //如果存在 commentId 是评论的评论数，否则是沸点的评论数
        if (getCommentId() == null) {
            return getCommentRepository().count(getPinId());
        } else {
            return getCommentRepository().count(getPinId(), getCommentId());
        }
    }

    public static class Builder {

        protected String pinId;

        protected String commentId;

        protected CommentRepository commentRepository;

        public Builder pinId(String pinId) {
            this.pinId = pinId;
            return this;
        }

        public Builder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        public Builder commentRepository(CommentRepository commentRepository) {
            this.commentRepository = commentRepository;
            return this;
        }

        public SchrodingerComments build() {
            if (!StringUtils.hasText(pinId)) {
                throw new IllegalArgumentException("Pin id required");
            }
            if (commentRepository == null) {
                throw new IllegalArgumentException("CommentRepository required");
            }
            return new SchrodingerComments(pinId, commentId, commentRepository);
        }
    }
}
