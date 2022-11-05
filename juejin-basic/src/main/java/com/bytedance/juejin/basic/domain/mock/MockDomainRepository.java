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
    public void doCreate(T object) {
        doUpdate(object);
    }

    @Override
    public void doCreate(Collection<? extends T> objects) {
        doUpdate(objects);
    }

    @Override
    public void doUpdate(T object) {
        mockMap.put(object.getId(), object);
    }

    @Override
    public void doUpdate(Collection<? extends T> objects) {
        objects.forEach(this::doUpdate);
    }

    @Override
    public void doDelete(T object) {
        doDelete(object.getId());
    }

    @Override
    public void doDelete(String id) {
        mockMap.remove(id);
    }

    @Override
    public void doDelete(Collection<String> ids) {
        ids.forEach(this::doDelete);
    }

    @Override
    protected T doGet(String id) {
        return mockMap.get(id);
    }

    @Override
    public Collection<T> doSelect(Collection<String> ids) {
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
    public void doDelete(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T doQuery(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long doCount(Conditions conditions) {
        return (long) mockMap.size();
    }

    @Override
    public List<T> doList(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pages<T> doPage(Conditions conditions, Pages.Args page) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> doStream(Conditions conditions) {
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
