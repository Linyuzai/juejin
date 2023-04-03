package com.bytedance.juejin.domain.comment;

import com.bytedance.juejin.domain.like.CommentLikes;
import com.bytedance.juejin.domain.pin.Pin;
import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.DomainEntity;
import com.github.linyuzai.domain.core.DomainObject;

import java.util.Date;

/**
 * 评论
 */
public interface Comment extends DomainEntity {

    Pin getPin();

    DomainObject getReplyTo();

    String getContent();

    User getUser();

    CommentComments getComments();

    CommentLikes getLikes();

    Date getCreateTime();
}
