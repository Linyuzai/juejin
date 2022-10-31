package com.bytedance.juejin.pin.domain.comment.view;

import com.bytedance.juejin.pin.domain.user.view.UserVO;
import lombok.Data;

@Data
public class CommentReplyVO {

    private String id;

    private String content;

    private UserVO user;

    private UserVO reply;

    private Long likeCount;

    private Long createTime;
}
