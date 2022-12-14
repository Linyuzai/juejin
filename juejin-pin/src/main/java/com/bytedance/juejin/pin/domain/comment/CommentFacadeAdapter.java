package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.comment.view.CommentQuery;
import com.bytedance.juejin.pin.domain.comment.view.CommentVO;
import com.bytedance.juejin.pin.domain.user.User;

/**
 * 评论模型与视图的转换适配器
 */
public interface CommentFacadeAdapter {

    Comment from(CommentCreateCommand create, User user);

    CommentVO do2vo(Comment comment);

    Conditions toConditions(CommentQuery query);
}
