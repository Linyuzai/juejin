package com.bytedance.juejin.pin.domain.pin.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.pin.Pins;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerClubPins extends SchrodingerPins implements Pins {

    protected SchrodingerClubPins(String clubId, DomainContext context) {
        this.ownerId = clubId;
        this.context = context;
    }

    @Override
    protected void onConditionsObtain(Conditions conditions, String id) {
        conditions.lambda().equal(User::getId, id);
    }

    @Override
    protected Class<?> getOwnerType() {
        return Club.class;
    }

    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return ClubRepository.class;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerClubPins, Builder> {

        @NotNull
        protected String clubId;

        public Builder clubId(String clubId) {
            this.clubId = clubId;
            return this;
        }

        @Override
        protected SchrodingerClubPins doBuild() {
            return new SchrodingerClubPins(clubId, context);
        }
    }
}
