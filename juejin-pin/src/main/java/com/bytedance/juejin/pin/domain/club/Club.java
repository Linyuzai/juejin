package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.DomainEntity;

/**
 * 圈子
 */
public interface Club extends DomainEntity {

    String getName();

    String getTag();

    String getDescription();
}
