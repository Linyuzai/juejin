package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.AbstractDomainBuilder;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeImpl implements Like {

    protected String id;

    protected PinOrComment owner;

    protected User user;

    protected Long createTime;

    public static class Builder extends AbstractDomainBuilder<LikeImpl, Builder> {

        @NotNull
        protected String id;

        @NotNull
        protected PinOrComment owner;

        @NotNull
        protected User user;

        @NotNull
        protected Long createTime;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder owner(PinOrComment owner) {
            this.owner = owner;
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

        @Override
        protected void initDefaultValue() {
            if (createTime == null) {
                createTime = System.currentTimeMillis();
            }
        }

        @Override
        protected LikeImpl doBuild() {
            return new LikeImpl(id, owner, user, createTime);
        }
    }
}
