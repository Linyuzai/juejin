package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.club.Clubs;

/**
 * 薛定谔的圈子集合模型
 */
public abstract class SchrodingerClubs extends SchrodingerDomainCollection<Club> implements Clubs {

    /**
     * 指定领域模型为圈子
     */
    @Override
    protected Class<? extends Club> getDomainType() {
        return Club.class;
    }

    /**
     * 指定存储为圈子存储
     */
    @Override
    protected Class<? extends DomainRepository<? extends Club>> getDomainRepositoryType() {
        return ClubRepository.class;
    }
}
