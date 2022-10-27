package com.bytedance.juejin.basic.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Getter
public abstract class AbstractDomainCollection<T extends DomainObject> implements DomainCollection<T> {

    protected Object owner;

    protected final Map<String, T> domainObjects = newContainer();

    protected Map<String, T> newContainer() {
        return new HashMap<>();
    }

    @Override
    public Object getOwner() {
        if (owner == null) {
            this.owner = doGetOwner();
        }
        return owner;
    }

    public abstract Object doGetOwner();

    @Override
    public T get(String id) {
        T exist = getDomainObjects().get(id);
        if (exist == null) {
            T get = doGet(id);
            if (get != null) {
                getDomainObjects().put(get.getId(), get);
            }
        }
        return exist;
    }

    public abstract T doGet(String id);

    @Override
    public Stream<T> stream() {
        return getDomainObjects().values().stream();
    }

    @Override
    public long count() {
        return getDomainObjects().size();
    }

    public static abstract class Builder<T extends DomainObject, B extends Builder<T, B>> extends AbstractDomainBuilder<T, B> {

        @NotNull
        protected Object owner;

        @SuppressWarnings("unchecked")
        public B owner(Object owner) {
            this.owner = owner;
            return (B) this;
        }
    }
}
