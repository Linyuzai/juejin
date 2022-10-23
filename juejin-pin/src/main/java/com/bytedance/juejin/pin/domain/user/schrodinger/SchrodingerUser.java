package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserImpl;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class SchrodingerUser extends UserImpl implements User {

    protected UserRepository userRepository;

    protected SchrodingerUser(String id, UserRepository userRepository) {
        this.id = id;
        this.userRepository = userRepository;
    }

    @Override
    public String getName() {
        if (super.getName() == null) {
            load();
        }
        return super.getName();
    }

    public void load() {
        User user = getUserRepository().get(id);
        if (user == null) {
            throw new JuejinException("User not found: " + id);
        }
        this.name = user.getName();
    }

    public static class Builder {

        protected String id;

        protected UserRepository userRepository;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder userRepository(UserRepository userRepository) {
            this.userRepository = userRepository;
            return this;
        }

        public SchrodingerUser build() {
            if (!StringUtils.hasText(id)) {
                throw new IllegalArgumentException("Id required");
            }
            if (userRepository == null) {
                throw new IllegalArgumentException("UserRepository required");
            }
            return new SchrodingerUser(id, userRepository);
        }
    }
}
