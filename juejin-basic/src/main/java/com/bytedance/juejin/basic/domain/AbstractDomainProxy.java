package com.bytedance.juejin.basic.domain;

import java.lang.reflect.Proxy;

public abstract class AbstractDomainProxy<T extends DomainObject> implements DomainProxy<T> {

    protected T target;

    @Override
    public T getTarget() {
        if (this.target == null) {
            this.target = doGetTarget();
        }
        return this.target;
    }

    public abstract T doGetTarget();

    @SuppressWarnings("unchecked")
    protected abstract static class Builder<T extends DomainObject, B extends Builder<T, B>> extends ContextDomainBuilder<T, B> {

        protected T proxy(Class<? extends T> type, DomainProxy<? extends T> proxy) {
            return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{type}, proxy);
        }
    }
}
