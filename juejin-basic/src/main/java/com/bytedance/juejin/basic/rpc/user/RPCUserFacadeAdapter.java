package com.bytedance.juejin.basic.rpc.user;

import com.bytedance.juejin.basic.rpc.RemoteObjectFacadeAdapter;
import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.domain.user.UserImpl;
import com.github.linyuzai.domain.core.DomainValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RPCUserFacadeAdapter implements RemoteObjectFacadeAdapter<User, UserRO> {

    @Autowired
    private DomainValidator validator;

    @Override
    public UserRO do2ro(User user) {
        UserRO ro = new UserRO();
        ro.setId(user.getId());
        ro.setUsername(user.getUsername());
        ro.setPassword("******");
        ro.setNickname(user.getNickname());
        ro.setAvatar(user.getAvatar());
        ro.setEnabled(user.getEnabled());
        ro.setCreateTime(user.getCreateTime().getTime());
        return ro;
    }

    @Override
    public User ro2do(UserRO ro) {
        return new UserImpl.Builder()
                .id(ro.getId())
                .username(ro.getUsername())
                .password(ro.getPassword())
                .nickname(ro.getNickname())
                .avatar(ro.getAvatar())
                .enabled(ro.getEnabled())
                .createTime(new Date(ro.getCreateTime()))
                .build(validator);
    }
}