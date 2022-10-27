package com.bytedance.juejin.basic.domain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public interface DomainProxy<T extends DomainObject> extends InvocationHandler {

    @Override
    default Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(getTarget(), args);
    }

    T getTarget();
}
