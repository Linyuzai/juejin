package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import com.bytedance.juejin.pin.domain.user.Users;

public abstract class SchrodingerUsers extends SchrodingerDomainCollection<User> implements Users {

    @Override
    protected Class<? extends User> getDomainType() {
        return User.class;
    }

    @Override
    protected Class<? extends DomainRepository<? extends User>> getDomainRepositoryType() {
        return UserRepository.class;
    }
}
