package com.bytedance.juejin.pin.domain.user;

import lombok.*;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserImpl implements User {

    protected String id;

    protected String name;

    public static class Builder {

        protected String id;

        protected String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public UserImpl build() {
            if (!StringUtils.hasText(id)) {
                throw new IllegalArgumentException("Id required");
            }
            if (!StringUtils.hasText(name)) {
                throw new IllegalArgumentException("Name required");
            }
            return new UserImpl(id, name);
        }
    }
}
