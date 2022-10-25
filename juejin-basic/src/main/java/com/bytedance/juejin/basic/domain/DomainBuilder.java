package com.bytedance.juejin.basic.domain;

public interface DomainBuilder<T extends DomainObject> {

    T build();
}
