package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.login.LoginArgumentAdapter;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;

/**
 * 获得当前登录的沸点用户信息
 */
public class UserLoginArgumentAdapter implements LoginArgumentAdapter, ApplicationContextAware {

    private volatile UserRepository userRepository;

    private ApplicationContext applicationContext;

    @Override
    public boolean support(MethodParameter parameter) {
        Class<?> type = parameter.getParameter().getType();
        return User.class.isAssignableFrom(type);
    }

    @Override
    public Object adapt(MethodParameter parameter) {
        if (userRepository == null) {
            synchronized (this) {
                if (userRepository == null) {
                    userRepository = applicationContext.getBean(UserRepository.class);
                }
            }
        }
        //假装登录用户的 id 是 1
        return userRepository.get("1");
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
