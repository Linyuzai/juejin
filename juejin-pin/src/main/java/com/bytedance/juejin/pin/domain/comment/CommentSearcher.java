package com.bytedance.juejin.pin.domain.comment;

public interface CommentSearcher {

    long count(String pinId);

    long count(String pinId, String commentId);
}
