package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainProxy;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerUser extends SchrodingerDomainProxy<User> {

    protected SchrodingerUser(String id, DomainContext context) {
        super(id, context);
    }

    @Override
    protected Class<? extends User> getDomainType() {
        return User.class;
    }

    @Override
    protected Class<? extends DomainRepository<? extends User>> getDomainRepositoryType() {
        return UserRepository.class;
    }

    public static class Builder extends SchrodingerDomainProxy.Builder<User, Builder> {

        @Override
        protected Class<? extends User> getDomainType() {
            return User.class;
        }

        @Override
        protected DomainProxy<? extends User> getDomainProxy() {
            return new SchrodingerUser(id, context);
        }
    }
}
