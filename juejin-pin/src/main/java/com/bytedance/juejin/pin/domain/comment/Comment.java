package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.user.User;

import java.util.Map;

public interface Comment extends DomainEntity {

    String getContent();

    User getUser();

    Map<String, Comment> getComments();

    Map<String, Like> getLikes();

    Long getCreateTime();

    /**
     * 添加评论
     */
    void addComment(Comment comment);

    /**
     * 删除评论
     */
    void deleteComment(Comment comment);

    /**
     * 获得评论
     */
    Comment getComment(String commentId);

    /**
     * 点赞，用户 id 作为 key
     */
    void addLike(Like like);

    /**
     * 取消点赞
     */
    void cancelLike(Like like);
}
