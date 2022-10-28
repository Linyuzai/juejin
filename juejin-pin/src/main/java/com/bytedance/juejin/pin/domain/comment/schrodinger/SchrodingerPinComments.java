package com.bytedance.juejin.pin.domain.comment.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.comment.*;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 薛定谔的评论集合
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerPinComments extends SchrodingerComments implements Comments {

    protected SchrodingerPinComments(String pinId, DomainContext context) {
        this.ownerId = pinId;
        this.context = context;
    }

    @Override
    protected void onConditionsObtain(Conditions conditions, String id) {
        conditions.lambda().equal(Pin::getId, id);
    }

    @Override
    protected Class<?> getOwnerType() {
        return Pin.class;
    }

    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return PinRepository.class;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerPinComments, Builder> {

        @NotNull
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
