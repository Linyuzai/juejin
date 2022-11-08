package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 沸点点赞集合的薛定谔模型
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerPinLikes extends SchrodingerLikes implements Likes {

    protected SchrodingerPinLikes(String pinId, DomainContext context) {
        this.ownerId = pinId;
        this.context = context;
    }

    @Override
    protected Conditions onConditionsObtain(Conditions conditions, String id) {
        return conditions.lambda().equal(Pin::getId, id);
    }

    @Override
    protected Class<?> getOwnerType() {
        return Pin.class;
    }

    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return PinRepository.class;
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
