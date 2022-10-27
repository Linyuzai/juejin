package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainProxy;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 薛定谔的点赞模型
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerLike implements DomainProxy<Like> {

    protected final String id;
    /**
     * 圈子存储
     */
    protected final DomainContext context;

    protected Like like;

    @Override
    public Like getTarget() {
        if (this.like == null) {
            LikeRepository likeRepository = context.get(LikeRepository.class);
            Like like = likeRepository.get(id);
            if (like == null) {
                throw new JuejinNotFoundException(Like.class, id);
            }
            this.like = like;
        }
        return this.like;
    }

    public static class Builder extends ContextDomainBuilder<Like, Builder> {

        @NotEmpty
        protected String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        protected Like doBuild() {
            return proxy(Like.class, new SchrodingerLike(id, context));
        }
    }
}
