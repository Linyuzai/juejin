package com.bytedance.juejin.basic.login;

import com.github.linyuzai.domain.core.DomainObject;
import com.github.linyuzai.domain.core.DomainRepository;
import com.github.linyuzai.domain.core.link.DomainLink;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;

public abstract class AbstractLoginArgumentAdapter implements LoginArgumentAdapter, ApplicationContextAware {

    private volatile DomainRepository<?, ?> repository;

    private ApplicationContext applicationContext;

    @Override
    public boolean support(MethodParameter parameter) {
        Class<?> type = parameter.getParameter().getType();
        return getParameterType().isAssignableFrom(type);
    }

    @Override
    public Object adapt(MethodParameter parameter) {
        if (repository == null) {
            synchronized (this) {
                if (repository == null) {
                    repository = applicationContext.getBean(getParameterRepositoryType());
                }
            }
        }
        String userId = LoginContext.getUserId();
        if (userId == null) {
            throw new IllegalStateException("未登录");
        }
        Object o = repository.get(userId);
        if (o == null) {
            throw new IllegalStateException("非法登录");
        }
        return o;
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public abstract Class<? extends DomainObject> getParameterType();

    public Class<? extends DomainRepository<?, ?>> getParameterRepositoryType() {
        return DomainLink.repository(getParameterType());
    }
}
