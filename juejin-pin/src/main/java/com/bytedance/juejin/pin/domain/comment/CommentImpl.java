package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.AbstractDomainBuilder;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    public static class Builder extends AbstractDomainBuilder<CommentImpl, Builder> {

        @NotEmpty
        protected String id;

        @NotEmpty
        protected String content;

        @NotNull
        protected User user;

        @NotNull
        protected Comments comments;

        @NotNull
        protected Likes likes;

        @NotNull
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

        @Override
        protected void initDefaultValue() {
            if (createTime == null) {
                createTime = System.currentTimeMillis();
            }
        }

        @Override
        public CommentImpl doBuild() {
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
