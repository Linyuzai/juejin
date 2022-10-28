package com.bytedance.juejin.basic.domain.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainObject;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.exception.JuejinIdRequiredException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public abstract class SchrodingerDomainCollection<T extends DomainObject> extends AbstractDomainCollection<T> {

    protected DomainContext context;

    @Override
    public Object getOwner() {
        if (owner == null) {
            this.owner = doGetOwner();
        }
        return owner;
    }

    protected abstract Object doGetOwner();

    @Override
    public T get(String id) {
        T exist = objects.get(id);
        if (exist == null) {
            T get = doGet(id);
            if (get != null) {
                objects.put(get.getId(), get);
            }
        }
        return exist;
    }

    protected T doGet(String id) {
        if (id == null) {
            throw new JuejinIdRequiredException(getDomainType());
        }
        DomainRepository<T> repository = context.get(getDomainRepositoryType());
        T domain = repository.get(id);
        if (domain == null) {
            throw new JuejinNotFoundException(getDomainType(), id);
        }
        return domain;
    }

    @Override
    public Stream<T> stream() {
        DomainRepository<T> repository = context.get(getDomainRepositoryType());
        return repository.stream(obtainConditions());
    }

    /**
     * 获得沸点的评论数
     */
    @Override
    public long count() {
        DomainRepository<T> repository = context.get(getDomainRepositoryType());
        return repository.count(obtainConditions());
    }

    protected abstract Class<T> getDomainType();

    protected abstract Class<? extends DomainRepository<T>> getDomainRepositoryType();

    protected abstract Conditions obtainConditions();
}
