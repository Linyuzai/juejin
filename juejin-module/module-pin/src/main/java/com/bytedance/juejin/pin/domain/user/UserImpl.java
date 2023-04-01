package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.basic.domain.AbstractDomainBuilder;
import com.bytedance.juejin.pin.domain.club.Clubs;
import com.bytedance.juejin.pin.domain.pin.Pins;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserImpl implements User {

    protected String id;

    protected String name;

    protected String profilePicture;

    protected Clubs clubs;

    protected Pins pins;

    public static class Builder extends AbstractDomainBuilder<UserImpl, Builder> {

        @NotNull
        protected String id;

        @NotNull
        protected String name;

        @NotNull
        protected String profilePicture;

        @NotNull
        protected Clubs clubs;

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

        public Builder profilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
            return this;
        }

        public Builder clubs(Clubs clubs) {
            this.clubs = clubs;
            return this;
        }

        public Builder pins(Pins pins) {
            this.pins = pins;
            return this;
        }

        @Override
        protected UserImpl doBuild() {
            return new UserImpl(id, name, profilePicture, clubs, pins);
        }
    }
}
