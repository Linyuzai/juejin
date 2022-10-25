package com.bytedance.juejin.basic.domain;

public interface DomainObject {

    default String getId() {
        throw new UnsupportedOperationException();
    }
}
