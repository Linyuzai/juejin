package com.bytedance.juejin.basic.domain;

import com.bytedance.juejin.basic.cache.Cache;
import com.bytedance.juejin.basic.cache.CacheProvider;
import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.page.Pages;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDomainRepository<T extends DomainObject, P extends IdProvider> implements DomainRepository<T> {

    @Autowired
    protected CacheProvider cacheProvider;

    protected volatile Cache<P> cache;

    protected Cache<P> getCache() {
        if (cache == null) {
            synchronized (this) {
                if (cache == null) {
                    cache = cacheProvider.get(this);
                }
            }
        }
        return cache;
    }

    public abstract P do2po(T object);

    public abstract T po2do(P object);

    @Override
    public void create(T object) {
        doCreate(do2po(object));
    }

    protected abstract void doCreate(P po);

    @Override
    public void create(Collection<? extends T> objects) {
        doCreate(objects.stream().map(this::do2po).collect(Collectors.toList()));
    }

    protected abstract void doCreate(Collection<? extends P> pos);

    @Override
    public void update(T object) {
        doUpdate(do2po(object));
        getCache().remove(object.getId());
    }

    protected abstract void doUpdate(P po);

    @Override
    public void update(Collection<? extends T> objects) {
        doUpdate(objects.stream().map(this::do2po).collect(Collectors.toList()));
        objects.stream().map(DomainObject::getId).forEach(getCache()::remove);
    }

    protected abstract void doUpdate(Collection<? extends P> pos);

    @Override
    public void delete(T object) {
        doDelete(do2po(object));
        getCache().remove(object.getId());
    }

    protected abstract void doDelete(P po);

    @Override
    public void delete(String id) {
        doDelete(id);
        getCache().remove(id);
    }

    protected abstract void doDelete(String id);

    @Override
    public void delete(Collection<String> ids) {
        doDelete(ids);
        ids.forEach(getCache()::remove);
    }

    protected abstract void doDelete(Collection<String> ids);

    @Override
    public T get(String id) {
        P cache = getCache().get(id);
        if (cache == null) {
            P po = doGet(id);
            if (po == null) {
                return null;
            }
            getCache().set(id, po);
            return po2do(po);
        }
        return po2do(cache);
    }

    protected abstract P doGet(String id);

    @Override
    public Collection<T> select(Collection<String> ids) {
        Collection<P> select = new ArrayList<>();
        Collection<String> unCachedIds = new ArrayList<>();
        for (String id : ids) {
            P cache = getCache().get(id);
            if (cache == null) {
                unCachedIds.add(id);
            } else {
                select.add(cache);
            }
        }
        Collection<P> pos = doSelect(unCachedIds);
        pos.forEach(it -> getCache().set(it.getId(), it));
        select.addAll(pos);
        return select
                .stream()
                .map(this::po2do)
                .collect(Collectors.toList());
    }

    protected abstract Collection<P> doSelect(Collection<String> ids);

    @Override
    public void delete(Conditions conditions) {
        doDelete(conditions);
    }

    protected abstract void doDelete(Conditions conditions);

    @Override
    public T query(Conditions conditions) {
        P po = doQuery(conditions);
        if (po == null) {
            return null;
        }
        return po2do(po);
    }

    protected abstract P doQuery(Conditions conditions);

    @Override
    public Long count(Conditions conditions) {
        return doCount(conditions);
    }

    protected abstract Long doCount(Conditions conditions);

    @Override
    public List<T> list(Conditions conditions) {
        return doList(conditions)
                .stream()
                .map(this::po2do)
                .collect(Collectors.toList());
    }

    protected abstract List<P> doList(Conditions conditions);

    @Override
    public Pages<T> page(Conditions conditions, Pages.Args page) {
        return doPage(conditions, page).map(this::po2do);
    }

    protected abstract Pages<P> doPage(Conditions conditions, Pages.Args page);

    @Override
    public Stream<T> stream(Conditions conditions) {
        return doStream(conditions).map(this::po2do);
    }

    protected abstract Stream<P> doStream(Conditions conditions);
}