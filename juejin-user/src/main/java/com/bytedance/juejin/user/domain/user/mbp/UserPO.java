package com.bytedance.juejin.user.domain.user.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bytedance.juejin.basic.domain.IdProvider;
import lombok.Data;

@Data
@TableName("t_user")
class UserPO implements IdProvider {

    @TableId(type = IdType.INPUT)
    private String id;

    private String name;

    private String profilePicture;
}
