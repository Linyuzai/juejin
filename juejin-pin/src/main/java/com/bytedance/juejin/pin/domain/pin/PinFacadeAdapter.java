package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinSnapshotVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.bytedance.juejin.pin.domain.user.User;

/**
 * 沸点模型与视图的转换适配器
 */
public interface PinFacadeAdapter {

    /**
     * 创建视图转沸点模型
     */
    Pin from(PinCreateCommand create, User user);

    /**
     * 沸点模型转沸点视图
     */
    PinVO do2vo(Pin pin);

    /**
     * 沸点模型转快照视图
     */
    PinSnapshotVO toSnapshot(Pin pin);
}
