package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerPinLikes extends SchrodingerLikes implements Likes {

    protected String pinId;

    protected SchrodingerPinLikes(String pinId, DomainContext context) {
        this.pinId = pinId;
        this.context = context;
    }

    @Override
    public Object doGetOwner() {
        PinRepository pinRepository = context.get(PinRepository.class);
        Pin pin = pinRepository.get(pinId);
        if (pin == null) {
            throw new JuejinNotFoundException(Pin.class, pinId);
        }
        return pin;
    }

    @Override
    protected Conditions obtainConditions() {
        LambdaConditions conditions = new LambdaConditions();
        conditions.equal(this::getPinId, pinId);
        return conditions;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerPinLikes, Builder> {

        @NotNull
        protected String pinId;

        public Builder pinId(String pinId) {
            this.pinId = pinId;
            return this;
        }

        @Override
        protected SchrodingerPinLikes doBuild() {
            return new SchrodingerPinLikes(pinId, context);
        }
    }
}
