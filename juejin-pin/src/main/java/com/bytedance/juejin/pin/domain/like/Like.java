package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.user.User;

public interface Like extends DomainEntity {

    PinOrComment getOwner();

    User getUser();

    Long getCreateTime();
}
