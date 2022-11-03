package com.bytedance.juejin.pin.domain.pin.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_pin")
class PinPO {

    @TableId(type = IdType.INPUT)
    private String id;

    private String content;

    private String clubId;

    private String userId;

    private Date createTime;

    @TableLogic
    private Boolean deleted;
}
