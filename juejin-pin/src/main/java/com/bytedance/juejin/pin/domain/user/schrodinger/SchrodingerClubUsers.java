package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.user.Users;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerClubUsers extends SchrodingerUsers implements Users {

    protected String clubId;

    protected SchrodingerClubUsers(String clubId, DomainContext context) {
        this.clubId = clubId;
        this.context = context;
    }

    @Override
    public Object doGetOwner() {
        ClubRepository clubRepository = context.get(ClubRepository.class);
        Club club = clubRepository.get(clubId);
        if (club == null) {
            throw new JuejinNotFoundException(Club.class, clubId);
        }
        return club;
    }

    @Override
    protected Conditions obtainConditions() {
        LambdaConditions conditions = new LambdaConditions();
        conditions.equal(Club::getId, clubId);
        return conditions;
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
