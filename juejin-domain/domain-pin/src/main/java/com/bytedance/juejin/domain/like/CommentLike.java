package com.bytedance.juejin.domain.like;

import com.bytedance.juejin.domain.comment.Comment;

public interface CommentLike extends Like {

    @Override
    Comment getLiked();
}
