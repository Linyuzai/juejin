package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.club.Club;

/**
 * 沸点
 */
public interface Pin extends PinOrComment, DomainEntity {

    Club getClub();
}
