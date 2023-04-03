package com.bytedance.juejin.domain.comment;

import com.bytedance.juejin.domain.like.CommentLikes;
import com.bytedance.juejin.domain.pin.Pin;
import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.AbstractDomainBuilder;
import com.github.linyuzai.domain.core.DomainObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 评论领域模型实现
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractComment implements Comment {

    protected String id;

    protected Pin pin;

    protected DomainObject replyTo;

    protected String content;

    protected User user;

    protected CommentComments comments;

    protected CommentLikes likes;

    protected Date createTime;

    @SuppressWarnings("unchecked")
    public static abstract class Builder<T extends DomainObject, C extends AbstractComment, B extends Builder<T, C, B>>
            extends AbstractDomainBuilder<C> {

        @NotEmpty
        protected String id;

        @NotNull
        protected Pin pin;

        @NotNull
        protected T replyTo;

        @NotEmpty
        protected String content;

        @NotNull
        protected User user;

        @NotNull
        protected CommentComments comments;

        @NotNull
        protected CommentLikes likes;

        @NotNull
        protected Date createTime;

        public B id(String id) {
            this.id = id;
            return (B) this;
        }

        public B pin(Pin pin) {
            this.pin = pin;
            return (B) this;
        }

        public B replyTo(T replyTo) {
            this.replyTo = replyTo;
            return (B) this;
        }

        public B content(String content) {
            this.content = content;
            return (B) this;
        }

        public B user(User user) {
            this.user = user;
            return (B) this;
        }

        public B comments(CommentComments comments) {
            this.comments = comments;
            return (B) this;
        }

        public B likes(CommentLikes likes) {
            this.likes = likes;
            return (B) this;
        }

        public B createTime(Date createTime) {
            this.createTime = createTime;
            return (B) this;
        }

        @Override
        protected void init() {
            if (createTime == null) {
                createTime = new Date();
            }
        }
    }
}
