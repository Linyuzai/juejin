package com.bytedance.juejin.pin.domain.comment;


import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 评论
 */
@Getter
public class CommentsImpl implements Comments {

    private final Map<String, Comment> comments = new HashMap<>();

    /**
     * 添加评论
     */
    @Override
    public void add(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment required");
        }
        getComments().put(comment.getId(), comment);
    }

    /**
     * 删除评论
     */
    @Override
    public void delete(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment required");
        }
        getComments().remove(comment.getId());
    }

    /**
     * 获得评论
     */
    @Override
    public Comment get(String commentId) {
        if (!StringUtils.hasText(commentId)) {
            throw new IllegalArgumentException("Comment id required");
        }
        return getComments().get(commentId);
    }

    /**
     * 评论数量
     */
    @Override
    public long count() {
        return getComments().size();
    }
}
