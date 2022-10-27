package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.comment.*;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * 薛定谔的评论集合
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerPinComments extends SchrodingerComments implements Comments {

    /**
     * 沸点ID
     */
    protected String pinId;

    public SchrodingerPinComments(String pinId, DomainContext context) {
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

    public static class Builder extends ContextDomainBuilder<SchrodingerPinComments, Builder> {

        @NotEmpty
        protected String pinId;

        public Builder pinId(String pinId) {
            this.pinId = pinId;
            return this;
        }

        @Override
        protected SchrodingerPinComments doBuild() {
            return new SchrodingerPinComments(pinId, context);
        }
    }
}
