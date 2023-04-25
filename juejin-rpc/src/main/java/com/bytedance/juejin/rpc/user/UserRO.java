package com.bytedance.juejin.rpc.user;

import com.github.linyuzai.domain.core.Identifiable;
import lombok.Data;

@Data
public class UserRO implements Identifiable {

    protected String id;

    protected String username;

    protected String password;

    protected String nickname;

    protected String avatar;

    protected Boolean enabled;

    protected Long createTime;
}
