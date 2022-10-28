package com.bytedance.juejin.pin.domain.pin.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.pin.Pins;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerUserPins extends SchrodingerPins implements Pins {

    protected SchrodingerUserPins(String userId, DomainContext context) {
        this.ownerId = userId;
        this.context = context;
    }

    @Override
    protected void onConditionsObtain(Conditions conditions, String id) {
        conditions.lambda().equal(User::getId, id);
    }

    @Override
    protected Class<?> getOwnerType() {
        return User.class;
    }

    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return UserRepository.class;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerUserPins, Builder> {

        @NotNull
        protected String userId;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        protected SchrodingerUserPins doBuild() {
            return new SchrodingerUserPins(userId, context);
        }
    }
}
