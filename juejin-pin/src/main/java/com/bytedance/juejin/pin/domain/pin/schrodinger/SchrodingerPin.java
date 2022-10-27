package com.bytedance.juejin.pin.domain.pin.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerUser;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerPin implements DomainProxy<Pin> {

    protected final String id;

    protected final DomainContext context;

    protected Pin pin;

    @Override
    public Pin getTarget() {
        if (this.pin == null) {
            PinRepository pinRepository = context.get(PinRepository.class);
            Pin pin = pinRepository.get(id);
            if (pin == null) {
                throw new JuejinNotFoundException(Pin.class, id);
            }
            this.pin = pin;
        }
        return this.pin;
    }

    public static class Builder extends ContextDomainBuilder<Pin, Builder> {

        @NotEmpty
        protected String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        protected Pin doBuild() {
            return proxy(Pin.class, new SchrodingerPin(id, context));
        }
    }
}
