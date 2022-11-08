package com.bytedance.juejin.basic.domain;

import java.util.stream.Stream;

public interface DomainCollection<T extends DomainObject> extends DomainObject {

    @Override
    default String getId() {
        throw new UnsupportedOperationException();
    }

    Object getOwner();

    T get(String id);

    Stream<? extends T> stream();

    Long count();
}
