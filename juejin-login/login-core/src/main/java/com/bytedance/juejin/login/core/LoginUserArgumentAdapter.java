package com.bytedance.juejin.login.core;

import com.bytedance.juejin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class LoginUserArgumentAdapter implements LoginArgumentAdapter {

    @Override
    public boolean support(MethodParameter parameter) {
        Class<?> type = parameter.getParameter().getType();
        return User.class == type;
    }

    @Override
    public Object adapt(MethodParameter parameter) {
        Login annotation = parameter.getMethodAnnotation(Login.class);
        User user = LoginContext.getUser();
        if (user == null) {
            if (!Objects.requireNonNull(annotation).required()) {
                return null;
            }
            throw new IllegalStateException("未登录");
        }
        return user;
    }
}
