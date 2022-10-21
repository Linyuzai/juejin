package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.user.User;

public interface PinFacadeAdapter {

    Pin from(PinCreateCommand create, User user);
}
