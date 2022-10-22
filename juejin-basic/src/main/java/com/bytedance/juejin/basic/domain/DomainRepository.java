package com.bytedance.juejin.basic.domain;

import java.util.Collection;

public interface DomainRepository<T extends DomainObject> {

    void create(T object);

    void create(Collection<? extends T> objects);

    void update(T object);

    void update(Collection<? extends T> objects);

    void delete(T object);

    void delete(Collection<? extends T> objects);

    T get(String id);

    Collection<? extends T> select(Collection<? extends String> ids);

    Collection<? extends T> all();

    long count();
}
