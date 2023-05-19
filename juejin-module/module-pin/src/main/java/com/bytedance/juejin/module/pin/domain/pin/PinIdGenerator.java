package com.bytedance.juejin.module.pin.domain.pin;

import com.bytedance.juejin.module.pin.domain.pin.view.PinCreateCommand;
import com.github.linyuzai.domain.core.DomainIdGenerator;

/**
 * 沸点 id 生成器
 */
public interface PinIdGenerator extends DomainIdGenerator<PinCreateCommand> {
}
