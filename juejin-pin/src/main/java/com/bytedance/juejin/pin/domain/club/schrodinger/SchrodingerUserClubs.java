package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.club.Clubs;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerUserClubs extends SchrodingerClubs implements Clubs {

    protected String userId;

    protected SchrodingerUserClubs(String userId, DomainContext context) {
        this.userId = userId;
        this.context = context;
    }

    @Override
    public Object doGetOwner() {
        UserRepository userRepository = context.get(UserRepository.class);
        User user = userRepository.get(userId);
        if (user == null) {
            throw new JuejinNotFoundException(User.class, userId);
        }
        return user;
    }

    @Override
    protected Conditions obtainConditions() {
        LambdaConditions conditions = new LambdaConditions();
        conditions.equal(User::getId, userId);
        return conditions;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerUserClubs, Builder> {

        @NotNull
        protected String userId;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        protected SchrodingerUserClubs doBuild() {
            return new SchrodingerUserClubs(userId, context);
        }
    }
}
