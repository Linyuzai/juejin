package com.bytedance.juejin.pin.domain.comment.mbp;

import lombok.Data;

import java.util.Date;

@Data
class CommentPO {

    private String id;

    private String pinId;

    private String commentId;

    protected String content;

    protected String userId;

    protected Date createTime;
}
