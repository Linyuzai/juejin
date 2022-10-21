package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.DomainObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * 圈子
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Club implements DomainObject {

    /**
     * 圈子ID
     */
    protected String id;

    /**
     * 圈子名称
     */
    protected String name;

    /**
     * 圈子标签
     */
    protected String tag;

    /**
     * 圈子描述
     */
    protected String description;

    public static class Builder {

        protected String id;

        protected String name;

        protected String tag;

        protected String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Club build() {
            if (!StringUtils.hasText(id)) {
                throw new IllegalArgumentException("Id required");
            }
            if (!StringUtils.hasText(name)) {
                throw new IllegalArgumentException("Name required");
            }
            if (!StringUtils.hasText(tag)) {
                throw new IllegalArgumentException("Tag required");
            }
            if (!StringUtils.hasText(description)) {
                throw new IllegalArgumentException("Description required");
            }
            return new Club(id, name, tag, description);
        }
    }
}
