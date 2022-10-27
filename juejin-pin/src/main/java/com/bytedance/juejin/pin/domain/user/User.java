package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.club.Clubs;
import com.bytedance.juejin.pin.domain.pin.Pins;

public interface User extends DomainEntity {

    String getName();

    Clubs getClubs();

    Pins getPins();
}
