package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.comment.Comments;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;

@Getter
public class PinImpl2 extends PinImpl implements Pin2 {

    protected String location;

    public PinImpl2(String id, String content, Club club, User user, Comments comments, Likes likes, Long createTime, String location) {
        super(id, content, club, user, comments, likes, createTime);
        this.location = location;
    }

    public static class Builder extends PinImpl.Builder {

        protected String location;

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        @Override
        protected PinImpl doBuild() {
            return new PinImpl2(
                    id,
                    content,
                    club,
                    user,
                    comments,
                    likes,
                    createTime,
                    location);
        }
    }
}
