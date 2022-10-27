package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.AbstractDomainBuilder;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.comment.Comments;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 沸点
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PinImpl implements Pin {

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
    protected Comments comments;

    /**
     * 点赞
     */
    protected Likes likes;

    /**
     * 发布时间
     */
    protected Long createTime;

    public static class Builder extends AbstractDomainBuilder<PinImpl, Builder> {

        @NotEmpty
        protected String id;

        @NotEmpty
        protected String content;

        protected Club club;

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

        public Builder club(Club club) {
            this.club = club;
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
        public void initDefaultValue() {
            if (createTime == null) {
                createTime = System.currentTimeMillis();
            }
        }

        @Override
        protected PinImpl doBuild() {
            return new PinImpl(
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
