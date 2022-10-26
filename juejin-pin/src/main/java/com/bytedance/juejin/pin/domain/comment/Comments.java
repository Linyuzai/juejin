package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainObject;
import com.bytedance.juejin.pin.domain.pin.Pin;

public interface Comments extends DomainObject {

    Pin getPin();

    Comment getComment();

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
