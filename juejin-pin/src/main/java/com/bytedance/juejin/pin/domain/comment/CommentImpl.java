package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentImpl implements Comment {

    protected String id;

    protected String content;

    protected User user;

    protected Map<String, Comment> comments;

    protected Map<String, Like> likes;

    protected Long createTime;

    /**
     * 评论沸点
     */
    @Override
    public void addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment required");
        }
        getComments().put(comment.getId(), comment);
    }

    /**
     * 删除评论
     */
    @Override
    public void deleteComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment required");
        }
        getComments().remove(comment.getId());
    }

    /**
     * 获得评论
     */
    @Override
    public Comment getComment(String commentId) {
        return getComments().get(commentId);
    }

    /**
     * 点赞，用户 id 作为 key
     */
    @Override
    public void addLike(Like like) {
        if (like == null) {
            throw new IllegalArgumentException("Like required");
        }
        getLikes().put(like.getUser().getId(), like);
    }

    /**
     * 取消点赞，用户 id 作为 key
     */
    @Override
    public void cancelLike(Like like) {
        if (like == null) {
            throw new IllegalArgumentException("Like required");
        }
        getLikes().remove(like.getUser().getId());
    }

    public static class Builder {

        protected String id;

        protected String content;

        protected User user;

        protected Map<String, Comment> comments;

        protected Map<String, Like> likes;

        protected Long createTime;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder comments(Map<String, Comment> comments) {
            this.comments = comments;
            return this;
        }

        public Builder likes(Map<String, Like> likes) {
            this.likes = likes;
            return this;
        }

        public Builder createTime(Long createTime) {
            this.createTime = createTime;
            return this;
        }

        public CommentImpl build() {
            if (!StringUtils.hasText(id)) {
                throw new IllegalArgumentException("Id required");
            }
            if (!StringUtils.hasText(content)) {
                throw new IllegalArgumentException("Content required");
            }
            if (user == null) {
                throw new IllegalArgumentException("User required");
            }
            if (comments == null) {
                comments = new LinkedHashMap<>();
            }
            if (likes == null) {
                likes = new LinkedHashMap<>();
            }
            if (createTime == null) {
                createTime = System.currentTimeMillis();
            }
            return new CommentImpl(
                    id,
                    content,
                    user,
                    comments,
                    likes,
                    createTime);
        }
    }
}
