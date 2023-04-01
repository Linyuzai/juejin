package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.pin.Pin;

/**
 * 评论
 */
public interface Comment extends PinOrComment, DomainEntity {

    /**
     * 属于沸点或评论
     */
    PinOrComment getOwner();

    /**
     * 获得沸点
     */
    default Pin getPin() {
        PinOrComment owner = getOwner();
        if (owner.isPin()) {
            return owner.asPin();
        }
        while (owner.isComment()) {
            owner = owner.asComment().getOwner();
        }
        if (owner.isPin()) {
            return owner.asPin();
        }
        return null;
    }
}
