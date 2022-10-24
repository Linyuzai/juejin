package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.user.User;

public interface CommentFacadeAdapter {

    Comment from(CommentCreateCommand create, User user);
}
