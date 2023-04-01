package com.bytedance.juejin.user.infrastructure.user.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bytedance.juejin.basic.domain.IdProvider;
import com.github.linyuzai.domain.core.Identifiable;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user")
class UserPO implements Identifiable {

    @TableId(type = IdType.INPUT)
    private String id;

    private String username;

    private String password;

    private String nickname;

    private String avatar;

    private Boolean enabled;

    private Date createTime;
}
