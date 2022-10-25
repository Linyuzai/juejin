package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainObject;

public interface Comments extends DomainObject {

    /**
     * 添加评论
     */
    void add(Comment comment);

    /**
     * 删除评论
     */
    void delete(Comment comment);

    /**
     * 获得评论
     */
    Comment get(String commentId);

    /**
     * 评论数量
     */
    long count();
}
