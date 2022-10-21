package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 沸点
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Pin implements DomainEntity {

    /**
     * 沸点ID
     */
    protected String id;

    /**
     * 沸点内容
     */
    protected String content;

    /**
     * 沸点圈子
     */
    protected Club club;

    /**
     * 沸点用户
     */
    protected User user;

    /**
     * 评论
     */
    protected Map<String, Comment> comments;

    /**
     * 点赞
     */
    protected Collection<Like> likes;

    /**
     * 发布时间
     */
    protected Long createTime;

    /**
     * 评论沸点
     */
    public void commented(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment required");
        }
        if (getComments().containsKey(comment.getId())) {
            throw new IllegalArgumentException("Comment existed");
        }
        getComments().put(comment.getId(), comment);
    }

    /**
     * 获得评论
     */
    public Comment getComment(String commentId) {
        return getComments().get(commentId);
    }

    public static class Builder {

        protected String id;

        protected String content;

        protected Club club;

        protected User user;

        protected Map<String, Comment> comments;

        protected Collection<Like> likes;

        protected Long createTime;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder club(Club club) {
            this.club = club;
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

        public Builder likes(Collection<Like> likes) {
            this.likes = likes;
            return this;
        }

        public Builder createTime(Long createTime) {
            this.createTime = createTime;
            return this;
        }

        public Pin build() {
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
                likes = new ArrayList<>();
            }
            if (createTime == null) {
                createTime = System.currentTimeMillis();
            }
            return new Pin(
                    id,
                    content,
                    club,
                    user,
                    comments,
                    likes,
                    createTime);
        }
    }
}
