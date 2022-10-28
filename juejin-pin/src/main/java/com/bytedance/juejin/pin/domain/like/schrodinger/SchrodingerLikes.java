package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.like.*;

public abstract class SchrodingerLikes extends SchrodingerDomainCollection<Like> implements Likes {

    @Override
    protected Class<Like> getDomainType() {
        return Like.class;
    }

    @Override
    protected Class<? extends DomainRepository<Like>> getDomainRepositoryType() {
        return LikeRepository.class;
    }
}
