package com.bytedance.juejin.basic.domain.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.AbstractDomainRepository;
import com.bytedance.juejin.basic.domain.DomainObject;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class MBPDomainRepository<T extends DomainObject, P> extends AbstractDomainRepository<T, P> {

    @Override
    public void create(T object) {
        getBaseMapper().insert(do2po(object));
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void create(Collection<? extends T> objects) {
        objects.forEach(this::create);
    }

    @Override
    public void update(T object) {
        getBaseMapper().updateById(do2po(object));
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void update(Collection<? extends T> objects) {
        objects.forEach(this::update);
    }

    @Override
    public void delete(T object) {
        getBaseMapper().deleteById(object.getId());
    }

    @Override
    public void delete(Collection<? extends T> objects) {
        Set<String> ids = objects.stream()
                .map(DomainObject::getId)
                .collect(Collectors.toSet());
        getBaseMapper().deleteBatchIds(ids);
    }

    @Override
    public T get(String id) {
        return po2do(getBaseMapper().selectById(id));
    }

    @Override
    public Collection<T> select(Collection<String> ids) {
        return getBaseMapper()
                .selectBatchIds(ids)
                .stream()
                .map(this::po2do)
                .collect(Collectors.toList());
    }

    public abstract BaseMapper<P> getBaseMapper();
}
