package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.user.Users;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerClubUsers extends SchrodingerUsers implements Users {

    protected SchrodingerClubUsers(String clubId, DomainContext context) {
        this.ownerId = clubId;
        this.context = context;
    }

    @Override
    protected void onConditionsObtain(Conditions conditions, String id) {
        conditions.lambda().equal(Club::getId, id);
    }

    @Override
    protected Class<?> getOwnerType() {
        return Club.class;
    }

    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return ClubRepository.class;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerClubUsers, Builder> {

        @NotNull
        protected String clubId;

        public Builder clubId(String clubId) {
            this.clubId = clubId;
            return this;
        }

        @Override
        protected SchrodingerClubUsers doBuild() {
            return new SchrodingerClubUsers(clubId, context);
        }
    }
}
