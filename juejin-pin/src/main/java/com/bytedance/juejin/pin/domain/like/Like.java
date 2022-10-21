package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;

@Getter
public class Like implements DomainEntity {

    protected User user;

    @Override
    public String getId() {
        return null;
    }
}
