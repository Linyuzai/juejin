package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerLike;
import org.springframework.stereotype.Component;

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
}
