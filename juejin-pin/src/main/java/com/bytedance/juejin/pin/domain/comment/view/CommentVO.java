package com.bytedance.juejin.pin.domain.comment.view;

import com.bytedance.juejin.pin.domain.user.view.UserVO;
import lombok.Data;

import java.util.List;

@Data
public class CommentVO {

    private String id;

    private String content;

    private UserVO user;

    private List<CommentReplyVO> replies;

    private Long commentCount;

    private Long likeCount;

    private Long createTime;
}
