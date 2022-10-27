package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import com.bytedance.juejin.basic.exception.JuejinCanNotHappenException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikesImpl extends AbstractDomainCollection<Like> implements Likes {

    protected LikesImpl(Object owner) {
        this.owner = owner;
    }

    @Override
    public Object doGetOwner() {
        throw new JuejinCanNotHappenException();
    }

    @Override
    public Like doGet(String id) {
        throw new JuejinNotFoundException(Like.class, id);
    }

    public static class Builder extends AbstractDomainCollection.Builder<LikesImpl, Builder> {

        @Override
        protected LikesImpl doBuild() {
            return new LikesImpl(owner);
        }
    }
}
