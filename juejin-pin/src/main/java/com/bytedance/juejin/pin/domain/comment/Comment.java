package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.PinOrComment;

public interface Comment extends PinOrComment, DomainEntity {

    PinOrComment getOwner();
}
