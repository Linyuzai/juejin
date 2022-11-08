package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerCommentLikes;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerLike;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerPinLikes;

public interface LikeInstantiator {

    LikeImpl.Builder newBuilder();

    SchrodingerLike.Builder newSchrodingerBuilder();

    SchrodingerPinLikes.Builder newSchrodingerCollectionBuilderOwnedPin();

    SchrodingerCommentLikes.Builder newSchrodingerCollectionBuilderOwnedComment();
}
