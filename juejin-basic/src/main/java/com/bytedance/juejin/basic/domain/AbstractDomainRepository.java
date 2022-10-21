package com.bytedance.juejin.basic.domain;

public abstract class AbstractDomainRepository<T extends DomainObject, P> implements DomainRepository<T> {

    public abstract P do2po(T object);

    public abstract T po2do(P object);
}