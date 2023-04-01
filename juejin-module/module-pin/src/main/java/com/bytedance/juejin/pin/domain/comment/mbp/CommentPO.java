package com.bytedance.juejin.pin.domain.comment.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bytedance.juejin.basic.domain.IdProvider;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_pin_comment")
class CommentPO implements IdProvider {

    /**
     * 评论 id
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 沸点 id
     */
    private String pinId;

    /**
     * 如果是评论的评论则存在评论 id
     */
    private String commentId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论的用户 id
     */
    private String userId;

    /**
     * 评论时间
     */
    private Date createTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Boolean deleted;
}
