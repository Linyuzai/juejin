package com.bytedance.juejin.pin.domain.comment.mbp;

import lombok.Data;

@Data
class CommentPO {

    private String id;

    private String pinId;

    private String commentId;

    protected String content;

    protected String userId;

    protected Long createTime;
}
