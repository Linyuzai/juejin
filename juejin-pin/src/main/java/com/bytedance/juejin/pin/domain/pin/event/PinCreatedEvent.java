package com.bytedance.juejin.pin.domain.pin.event;

import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PinCreatedEvent {

    private final Pin pin;

    private final User user;
}
