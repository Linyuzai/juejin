package com.bytedance.juejin.pin.domain.pin.schrodinger;

import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import com.bytedance.juejin.pin.domain.pin.Pins;

public abstract class SchrodingerPins extends SchrodingerDomainCollection<Pin> implements Pins {

    @Override
    protected Class<? extends Pin> getDomainType() {
        return Pin.class;
    }

    @Override
    protected Class<? extends DomainRepository<? extends Pin>> getDomainRepositoryType() {
        return PinRepository.class;
    }
}
