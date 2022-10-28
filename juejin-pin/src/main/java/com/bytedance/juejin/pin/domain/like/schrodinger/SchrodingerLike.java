package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainProxy;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 薛定谔的点赞模型
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerLike extends SchrodingerDomainProxy<Like> {

    protected SchrodingerLike(String id, DomainContext context) {
        super(id, context);
    }

    @Override
    protected Class<Like> getDomainType() {
        return Like.class;
    }

    @Override
    protected Class<? extends DomainRepository<Like>> getDomainRepositoryType() {
        return LikeRepository.class;
    }

    public static class Builder extends SchrodingerDomainProxy.Builder<Like, Builder> {

        @Override
        protected Class<Like> getDomainType() {
            return Like.class;
        }

        @Override
        protected DomainProxy<Like> getDomainProxy() {
            return new SchrodingerLike(id, context);
        }
    }
}
