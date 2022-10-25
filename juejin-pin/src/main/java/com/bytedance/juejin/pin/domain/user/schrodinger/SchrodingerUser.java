package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserImpl;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class SchrodingerUser extends UserImpl implements User {

    protected DomainContext context;

    protected SchrodingerUser(String id, DomainContext context) {
        this.id = id;
        this.context = context;
    }

    @Override
    public String getName() {
        if (super.getName() == null) {
            load();
        }
        return super.getName();
    }

    public void load() {
        UserRepository userRepository = getContext().get(UserRepository.class);
        User user = userRepository.get(id);
        if (user == null) {
            throw new JuejinException("User not found: " + id);
        }
        this.name = user.getName();
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerUser, Builder> {

        @NotEmpty
        protected String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public SchrodingerUser doBuild() {
            return new SchrodingerUser(id, context);
        }
    }
}
