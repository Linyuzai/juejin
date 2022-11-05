package com.bytedance.juejin.pin.domain.like.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bytedance.juejin.basic.domain.IdProvider;
import lombok.Data;

@Data
@TableName("t_pin_like")
class LikePO implements IdProvider {

    @TableId(type = IdType.INPUT)
    private String id;

    private String pinId;

    private String commentId;

    private String userId;
}
