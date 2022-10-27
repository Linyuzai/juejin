package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.like.Likes;
import com.bytedance.juejin.pin.domain.user.User;

public interface Comment extends PinOrComment, DomainEntity {

    PinOrComment getOwner();

    String getContent();

    User getUser();

    Comments getComments();

    Likes getLikes();

    Long getCreateTime();
}
