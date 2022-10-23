package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeImpl implements Like {

    protected String id;

    protected User user;

    protected Long createTime;

    public static class Builder {

        protected String id;

        protected User user;

        protected Long createTime;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder createTime(Long createTime) {
            this.createTime = createTime;
            return this;
        }

        public LikeImpl build() {
            if (!StringUtils.hasText(id)) {
                throw new IllegalArgumentException("Id required");
            }
            if (user == null) {
                throw new IllegalArgumentException("User required");
            }
            if (createTime == null) {
                createTime = System.currentTimeMillis();
            }
            return new LikeImpl(id, user, createTime);
        }
    }
}
