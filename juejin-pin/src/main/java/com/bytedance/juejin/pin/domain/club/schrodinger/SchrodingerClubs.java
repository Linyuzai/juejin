package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.club.Clubs;

public abstract class SchrodingerClubs extends SchrodingerDomainCollection<Club> implements Clubs {

    @Override
    protected Class<Club> getDomainType() {
        return Club.class;
    }

    @Override
    protected Class<? extends DomainRepository<Club>> getDomainRepositoryType() {
        return ClubRepository.class;
    }
}
