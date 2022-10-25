package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.like.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerLikes extends LikesImpl implements Likes {

    protected String pinId;

    protected String commentId;

    protected DomainContext context;

    @Override
    public Like get(String userId) {
        Like exist = super.get(userId);
        if (exist == null) {
            Like like;
            LikeRepository likeRepository = getContext().get(LikeRepository.class);
            if (getCommentId() == null) {
                like = likeRepository.get(getPinId(), userId);
            } else {
                like = likeRepository.get(getPinId(), getCommentId(), userId);
            }
            if (like == null) {
                throw new JuejinException("Like not found: " + userId);
            }
            getLikes().put(userId, like);
            return like;
        }
        return exist;
    }

    @Override
    public long count() {
        LikeRepository likeRepository = getContext().get(LikeRepository.class);
        if (getCommentId() == null) {
            return likeRepository.count(getPinId());
        } else {
            return likeRepository.count(getPinId(), getCommentId());
        }
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerLikes, Builder> {

        @NotEmpty
        protected String pinId;

        protected String commentId;

        public Builder pinId(String pinId) {
            this.pinId = pinId;
            return this;
        }

        public Builder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        @Override
        public SchrodingerLikes doBuild() {
            return new SchrodingerLikes(pinId, commentId, context);
        }
    }
}
