package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerCommentLikes;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerLike;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerPinLikes;
import org.springframework.stereotype.Component;

/**
 * 点赞实例化器实现
 */
@Component
public class LikeInstantiatorImpl implements LikeInstantiator {

    @Override
    public LikeImpl.Builder newBuilder() {
        return new LikeImpl.Builder();
    }

    @Override
    public SchrodingerLike.Builder newSchrodingerBuilder() {
        return new SchrodingerLike.Builder();
    }

    @Override
    public SchrodingerPinLikes.Builder newSchrodingerCollectionBuilderOwnedPin() {
        return new SchrodingerPinLikes.Builder();
    }

    @Override
    public SchrodingerCommentLikes.Builder newSchrodingerCollectionBuilderOwnedComment() {
        return new SchrodingerCommentLikes.Builder();
    }
}
