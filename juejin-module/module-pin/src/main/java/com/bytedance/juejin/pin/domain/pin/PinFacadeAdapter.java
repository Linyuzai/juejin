package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.domain.pin.Pin;
import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinQuery;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.github.linyuzai.domain.core.condition.Conditions;

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
     * 查询转条件
     */
    Conditions toConditions(PinQuery query);
}
