package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.basic.domain.DomainEntity;

public interface User extends DomainEntity {

    String getName();

    String getProfilePicture();
}
