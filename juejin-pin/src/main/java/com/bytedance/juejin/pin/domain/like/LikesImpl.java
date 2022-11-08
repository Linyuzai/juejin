package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import com.bytedance.juejin.basic.domain.DomainObject;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 点赞集合实现
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikesImpl extends AbstractDomainCollection<Like> implements Likes {

    protected LikesImpl(Object owner, Map<String, Like> likes) {
        super(owner, likes);
    }

    @Override
    public boolean isLiked(User user) {
        Set<String> userIds = stream()
                .map(Like::getUser)
                .map(DomainObject::getId)
                .collect(Collectors.toSet());
        return userIds.contains(user.getId());
    }

    public static class Builder extends AbstractDomainCollection.Builder<Like, LikesImpl, Builder> {

        @Override
        protected LikesImpl doBuild() {
            return new LikesImpl(owner, getObjectMap());
        }
    }
}
