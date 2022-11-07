package com.bytedance.juejin.pin.domain.like;


import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerLike;

public interface LikeInstantiator {

    LikeImpl.Builder newBuilder();

    SchrodingerLike.Builder newSchrodingerBuilder();
}
