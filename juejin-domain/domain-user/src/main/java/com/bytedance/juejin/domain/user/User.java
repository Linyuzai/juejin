package com.bytedance.juejin.domain.user;

import com.github.linyuzai.domain.core.DomainEntity;

import java.util.Date;

public interface User extends DomainEntity {

    String getUsername();

    String getPassword();

    String getNickname();

    String getAvatar();

    Boolean getEnabled();

    Date getCreateTime();

    void changePassword(String password);
}
