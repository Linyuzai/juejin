package com.bytedance.juejin.pin.domain.like.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_pin_like")
public class LikePO {

    @TableId(type = IdType.INPUT)
    private String id;

    private String pinId;

    private String commentId;

    private String userId;
}
