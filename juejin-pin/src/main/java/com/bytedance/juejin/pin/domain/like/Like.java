package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainValue;
import com.bytedance.juejin.pin.domain.user.User;

public interface Like extends DomainValue {

    User getUser();

    Long getCreateTime();
}
