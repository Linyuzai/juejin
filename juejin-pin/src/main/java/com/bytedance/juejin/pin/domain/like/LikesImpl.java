package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikesImpl extends AbstractDomainCollection<Like> implements Likes {

    protected LikesImpl(Object owner, Map<String, Like> likes) {
        super(owner, likes);
    }

    public static class Builder extends AbstractDomainCollection.Builder<Like, LikesImpl, Builder> {

        @Override
        protected LikesImpl doBuild() {
            return new LikesImpl(owner, getObjectMap());
        }
    }
}
