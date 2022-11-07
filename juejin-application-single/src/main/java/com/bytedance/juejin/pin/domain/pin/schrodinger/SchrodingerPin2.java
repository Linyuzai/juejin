package com.bytedance.juejin.pin.domain.pin.schrodinger;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.Pin2;

public class SchrodingerPin2 extends SchrodingerPin {

    public SchrodingerPin2(String id, DomainContext context) {
        super(id, context);
    }

    @Override
    protected Class<? extends Pin> getDomainType() {
        return Pin2.class;
    }

    public static class Builder extends SchrodingerPin.Builder {

        @Override
        protected Class<? extends Pin> getDomainType() {
            return Pin2.class;
        }

        @Override
        protected DomainProxy<? extends Pin> getDomainProxy() {
            return new SchrodingerPin2(id, context);
        }
    }
}
