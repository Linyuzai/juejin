package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.DomainObject;

/**
 * 圈子
 */
public interface Club extends DomainObject {

    String getName();

    String getTag();

    String getDescription();
}
