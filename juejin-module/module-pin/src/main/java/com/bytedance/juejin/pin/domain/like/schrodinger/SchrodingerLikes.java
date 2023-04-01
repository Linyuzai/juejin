package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.DomainObject;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.basic.domain.schrodinger.SchrodingerDomainCollection;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.user.User;

/**
 * 点赞集合的薛定谔模型
 */
public abstract class SchrodingerLikes extends SchrodingerDomainCollection<Like> implements Likes {

    @Override
    protected Class<? extends Like> getDomainType() {
        return Like.class;
    }

    @Override
    protected Class<? extends DomainRepository<? extends Like>> getDomainRepositoryType() {
        return LikeRepository.class;
    }

    @Override
    public Long count() {
        LikeRepository likeRepository = context.get(LikeRepository.class);
        return likeRepository.stream(obtainConditions())
                .map(Like::getUser)
                .map(DomainObject::getId)
                .distinct()
                .count();
    }

    @Override
    public boolean isLiked(User user) {
        LikeRepository likeRepository = context.get(LikeRepository.class);
        LambdaConditions conditions = obtainConditions()
                .lambda()
                .equal(User::getId, user.getId());
        return likeRepository.count(conditions) > 0;
    }
}
