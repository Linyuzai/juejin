package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerUser implements DomainProxy<User> {

    protected final String id;

    protected final DomainContext context;

    protected User user;

    @Override
    public User getTarget() {
        if (this.user == null) {
            UserRepository userRepository = context.get(UserRepository.class);
            User user = userRepository.get(id);
            if (user == null) {
                throw new JuejinNotFoundException(User.class, id);
            }
            this.user = user;
        }
        return this.user;
    }

    public static class Builder extends ContextDomainBuilder<User, Builder> {

        @NotEmpty
        protected String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        protected User doBuild() {
            return proxy(User.class, new SchrodingerUser(id, context));
        }
    }
}
