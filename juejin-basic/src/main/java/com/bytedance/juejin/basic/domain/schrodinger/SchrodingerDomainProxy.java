package com.bytedance.juejin.basic.domain.schrodinger;

import com.bytedance.juejin.basic.domain.*;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SchrodingerDomainProxy<T extends DomainObject> extends AbstractDomainProxy<T> {

    protected String id;

    protected DomainContext context;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getId".equals(method.getName())) {
            return id;
        }
        return super.invoke(proxy, method, args);
    }

    @Override
    public T doGetTarget() {
        DomainRepository<? extends T> repository = context.get(getDomainRepositoryType());
        T domain = repository.get(id);
        if (domain == null) {
            throw new JuejinNotFoundException(getDomainType(), id);
        }
        return domain;
    }

    protected abstract Class<? extends T> getDomainType();

    protected abstract Class<? extends DomainRepository<? extends T>> getDomainRepositoryType();

    protected abstract static class Builder<T extends DomainObject, B extends Builder<T, B>> extends AbstractDomainProxy.Builder<T, B> {

        @NotNull
        protected String id;

        @SuppressWarnings("unchecked")
        public B id(String id) {
            this.id = id;
            return (B) this;
        }

        @Override
        protected T doBuild() {
            return proxy(getDomainType(), getDomainProxy());
        }

        protected abstract Class<? extends T> getDomainType();

        protected abstract DomainProxy<? extends T> getDomainProxy();
    }
}
