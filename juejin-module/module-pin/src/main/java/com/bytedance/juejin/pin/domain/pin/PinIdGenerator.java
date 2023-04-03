package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.github.linyuzai.domain.core.DomainIdGenerator;

public interface PinIdGenerator extends DomainIdGenerator<PinCreateCommand> {
}
