package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.login.LoginArgumentAdapter;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserImpl;
import org.springframework.core.MethodParameter;

public class UserLoginArgumentAdapter implements LoginArgumentAdapter {

    @Override
    public boolean support(MethodParameter parameter) {
        Class<?> type = parameter.getParameter().getType();
        return User.class.isAssignableFrom(type);
    }

    @Override
    public Object adapt(MethodParameter parameter) {
        return new UserImpl.Builder()
                .id("1")
                .name("admin")
                .build();
    }
}
