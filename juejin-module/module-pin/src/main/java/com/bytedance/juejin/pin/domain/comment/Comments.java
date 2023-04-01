package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainCollection;

import java.util.List;

/**
 * 评论集合
 */
public interface Comments extends DomainCollection<Comment> {

    /**
     * 获得最新的 n 条评论
     */
    List<Comment> getNewestList(int count);
}
