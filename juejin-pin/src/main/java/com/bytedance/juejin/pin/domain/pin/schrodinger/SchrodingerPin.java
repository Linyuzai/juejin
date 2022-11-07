package com.bytedance.juejin.pin.domain.pin.schrodinger;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainProxy;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerPin extends SchrodingerDomainProxy<Pin> {

    protected SchrodingerPin(String id, DomainContext context) {
        super(id, context);
    }

    @Override
    protected Class<? extends Pin> getDomainType() {
        return Pin.class;
    }

    @Override
    protected Class<? extends DomainRepository<? extends Pin>> getDomainRepositoryType() {
        return PinRepository.class;
    }

    public static class Builder extends SchrodingerDomainProxy.Builder<Pin, Builder> {

        @Override
        protected Class<? extends Pin> getDomainType() {
            return Pin.class;
        }

        @Override
        protected DomainProxy<? extends Pin> getDomainProxy() {
            return new SchrodingerPin(id, context);
        }
    }
}
