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

    @TableId(type = IdType.INPUT)
    private String id;

    private String pinId;

    private String commentId;

    private String content;

    private String userId;

    private Date createTime;

    @TableLogic
    private Boolean deleted;
}
