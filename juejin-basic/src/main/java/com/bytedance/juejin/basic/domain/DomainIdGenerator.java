package com.bytedance.juejin.basic.domain;

public interface DomainIdGenerator<T extends DomainObject> {

    String generateId(Class<T> domainClass);
}
