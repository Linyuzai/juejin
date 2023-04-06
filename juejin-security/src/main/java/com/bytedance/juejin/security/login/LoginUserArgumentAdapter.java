package com.bytedance.juejin.security.login;

import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.DomainFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;

@Getter
@RequiredArgsConstructor
public class LoginUserArgumentAdapter implements LoginArgumentAdapter {

    private final DomainFactory factory;

    @Override
    public boolean support(MethodParameter parameter) {
        Class<?> type = parameter.getParameter().getType();
        return User.class.isAssignableFrom(type);
    }

    @Override
    public Object adapt(MethodParameter parameter) {
        String userId = LoginContext.getUserId();
        if (userId == null) {
            throw new IllegalStateException("未登录");
        }
        return factory.createObject(User.class, userId);
    }
}
