package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 薛定谔的圈子模型
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerClub implements DomainProxy<Club> {

    protected final String id;
    /**
     * 圈子存储
     */
    protected final DomainContext context;

    protected Club club;

    @Override
    public Club getTarget() {
        if (this.club == null) {
            ClubRepository clubRepository = context.get(ClubRepository.class);
            Club club = clubRepository.get(id);
            if (club == null) {
                throw new JuejinNotFoundException(Club.class, id);
            }
            this.club = club;
        }
        return this.club;
    }

    public static class Builder extends ContextDomainBuilder<Club, Builder> {

        @NotEmpty
        protected String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        protected Club doBuild() {
            return proxy(Club.class, new SchrodingerClub(id, context));
        }
    }
}
