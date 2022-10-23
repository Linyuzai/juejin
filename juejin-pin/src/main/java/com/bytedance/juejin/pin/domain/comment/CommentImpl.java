package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentImpl implements Comment {

    protected String id;

    protected String content;

    protected User user;

    protected Comments comments;

    protected Likes likes;

    protected Long createTime;

    public static class Builder {

        protected String id;

        protected String content;

        protected User user;

        protected Comments comments;

        protected Likes likes;

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

        public Builder comments(Comments comments) {
            this.comments = comments;
            return this;
        }

        public Builder likes(Likes likes) {
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
                throw new IllegalArgumentException("Comments required");
            }
            if (likes == null) {
                throw new IllegalArgumentException("Likes required");
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
