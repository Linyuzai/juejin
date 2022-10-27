package com.bytedance.juejin.basic.domain;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Proxy;

@SuppressWarnings("unchecked")
public abstract class ContextDomainBuilder<T extends DomainObject, B> extends AbstractDomainBuilder<T, B> {

    @NotNull
    protected DomainContext context;

    public B context(DomainContext context) {
        this.context = context;
        return (B) this;
    }

    protected T proxy(Class<T> type, DomainProxy<T> proxy) {
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{type}, proxy);
    }
}
