package com.bytedance.juejin.domain.comment;

public interface CommentComment extends Comment {

    @Override
    Comment getReplyTo();
}
