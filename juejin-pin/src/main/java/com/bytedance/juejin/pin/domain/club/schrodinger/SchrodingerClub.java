package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainProxy;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 薛定谔的圈子模型
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerClub extends SchrodingerDomainProxy<Club> {

    protected SchrodingerClub(String id, DomainContext context) {
        super(id, context);
    }

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

    public static class Builder extends SchrodingerDomainProxy.Builder<Club, Builder> {

        /**
         * 指定领域模型为圈子
         */
        @Override
        protected Class<? extends Club> getDomainType() {
            return Club.class;
        }

        /**
         * 获得圈子的领域代理
         */
        @Override
        protected DomainProxy<? extends Club> getDomainProxy() {
            return new SchrodingerClub(id, context);
        }
    }
}
