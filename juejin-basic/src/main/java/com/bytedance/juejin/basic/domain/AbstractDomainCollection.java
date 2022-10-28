package com.bytedance.juejin.basic.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractDomainCollection<T extends DomainObject> implements DomainCollection<T> {

    protected Object owner;

    protected Map<String, T> objects;

    @Override
    public T get(String id) {
        return objects.get(id);
    }

    @Override
    public Stream<T> stream() {
        return objects.values().stream();
    }

    @Override
    public Long count() {
        return Integer.valueOf(objects.size()).longValue();
    }

    @SuppressWarnings("unchecked")
    protected static abstract class Builder<T extends DomainObject, C extends DomainCollection<T>, B extends Builder<T, C, B>> extends AbstractDomainBuilder<C, B> {

        @NotNull
        protected Object owner;

        @NotNull
        protected Collection<? extends T> objects;

        public B owner(Object owner) {
            this.owner = owner;
            return (B) this;
        }

        public B objects(Collection<? extends T> objects) {
            this.objects = objects;
            return (B) this;
        }

        @Override
        protected void initDefaultValue() {
            if (objects == null) {
                objects = new ArrayList<>();
            }
        }

        protected Map<String, T> getObjectMap() {
            return objects.stream()
                    .collect(Collectors.toMap(DomainObject::getId,
                            Function.identity()));
        }
    }
}
