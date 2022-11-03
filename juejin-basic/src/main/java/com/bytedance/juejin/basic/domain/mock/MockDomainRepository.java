package com.bytedance.juejin.basic.domain.mock;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.AbstractDomainRepository;
import com.bytedance.juejin.basic.domain.DomainObject;
import com.bytedance.juejin.basic.page.Pages;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Getter
public abstract class MockDomainRepository<T extends DomainObject> extends AbstractDomainRepository<T, T> {

    protected final Map<String, T> mockMap = new ConcurrentHashMap<>(initMockMap());

    @Override
    public void create(T object) {
        update(object);
    }

    @Override
    public void create(Collection<? extends T> objects) {
        update(objects);
    }

    @Override
    public void update(T object) {
        mockMap.put(object.getId(), object);
    }

    @Override
    public void update(Collection<? extends T> objects) {
        objects.forEach(this::update);
    }

    @Override
    public void delete(T object) {
        mockMap.remove(object.getId());
    }

    @Override
    public void delete(Collection<? extends T> objects) {
        objects.forEach(this::delete);
    }

    @Override
    public T get(String id) {
        return mockMap.get(id);
    }

    @Override
    public Collection<T> select(Collection<String> ids) {
        List<T> list = new ArrayList<>();
        for (String id : ids) {
            T t = mockMap.get(id);
            if (t == null) {
                continue;
            }
            list.add(t);
        }
        return list;
    }

    @Override
    public void delete(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T query(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long count(Conditions conditions) {
        return (long) mockMap.size();
    }

    @Override
    public List<T> list(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pages<T> page(Conditions conditions, Pages.Args page) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> stream(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T do2po(T object) {
        return object;
    }

    @Override
    public T po2do(T object) {
        return object;
    }

    public abstract Map<String, T> initMockMap();
}
