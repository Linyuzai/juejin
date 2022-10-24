package com.bytedance.juejin.pin.domain.like.schrodinger;

import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.like.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerLikes extends LikesImpl implements Likes {

    protected String pinId;

    protected String commentId;

    protected LikeRepository likeRepository;

    @Override
    public Like get(String userId) {
        Like exist = super.get(userId);
        if (exist == null) {
            Like like;
            if (getCommentId() == null) {
                like = getLikeRepository().get(getPinId(), userId);
            } else {
                like = getLikeRepository().get(getPinId(), getCommentId(), userId);
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
        if (getCommentId() == null) {
            return getLikeRepository().count(getPinId());
        } else {
            return getLikeRepository().count(getPinId(), getCommentId());
        }
    }

    public static class Builder {

        protected String pinId;

        protected String commentId;

        protected LikeRepository likeRepository;

        public Builder pinId(String pinId) {
            this.pinId = pinId;
            return this;
        }

        public Builder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        public Builder likeRepository(LikeRepository likeRepository) {
            this.likeRepository = likeRepository;
            return this;
        }

        public SchrodingerLikes build() {
            if (!StringUtils.hasText(pinId)) {
                throw new IllegalArgumentException("Pin id required");
            }
            if (likeRepository == null) {
                throw new IllegalArgumentException("LikeRepository required");
            }
            return new SchrodingerLikes(pinId, commentId, likeRepository);
        }
    }
}
