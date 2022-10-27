package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.AbstractDomainBuilder;
import com.bytedance.juejin.pin.domain.pin.Pins;
import com.bytedance.juejin.pin.domain.user.Users;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 圈子
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubImpl implements Club {

    /**
     * 圈子ID
     */
    protected String id;

    /**
     * 圈子名称
     */
    protected String name;

    /**
     * 圈子图标
     */
    protected String logo;

    /**
     * 圈子类别
     */
    protected String category;

    /**
     * 圈子描述
     */
    protected String description;

    /**
     * 圈子公告
     */
    protected String announcement;

    /**
     * 圈子用户
     */
    protected Users users;

    /**
     * 圈子沸点
     */
    protected Pins pins;

    public static class Builder extends AbstractDomainBuilder<ClubImpl, Builder> {

        @NotEmpty
        protected String id;

        @NotEmpty
        protected String name;

        @NotEmpty
        protected String logo;

        @NotEmpty
        protected String category;

        @NotEmpty
        protected String description;

        protected String announcement;

        @NotNull
        protected Users users;

        @NotNull
        protected Pins pins;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder logo(String logo) {
            this.logo = logo;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder announcement(String announcement) {
            this.announcement = announcement;
            return this;
        }

        public Builder users(Users users) {
            this.users = users;
            return this;
        }

        public Builder pins(Pins pins) {
            this.pins = pins;
            return this;
        }

        @Override
        protected ClubImpl doBuild() {
            return new ClubImpl(
                    id,
                    name,
                    logo,
                    category,
                    description,
                    announcement,
                    users,
                    pins);
        }
    }
}
