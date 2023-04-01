package com.bytedance.juejin.pin.domain.like.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bytedance.juejin.basic.domain.IdProvider;
import lombok.Data;

@Data
@TableName("t_pin_like")
class LikePO implements IdProvider {

    /**
     * 点赞 id
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 给沸点点赞则存在沸点 id
     */
    private String pinId;

    /**
     * 给评论点赞则存在评论 id
     */
    private String commentId;

    /**
     * 点赞用户
     */
    private String userId;
}
