package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.login.LoginArgumentAdapter;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.MethodParameter;

@AllArgsConstructor
public class UserLoginArgumentAdapter implements LoginArgumentAdapter {

    private UserRepository userRepository;

    @Override
    public boolean support(MethodParameter parameter) {
        Class<?> type = parameter.getParameter().getType();
        return User.class.isAssignableFrom(type);
    }

    @Override
    public Object adapt(MethodParameter parameter) {
        //假装登录用户的 id 是 1
        return userRepository.get("1");
    }
}
