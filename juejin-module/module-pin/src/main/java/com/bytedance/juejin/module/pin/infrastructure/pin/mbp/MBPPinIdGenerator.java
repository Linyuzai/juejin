package com.bytedance.juejin.module.pin.infrastructure.pin.mbp;

import com.bytedance.juejin.module.pin.domain.pin.PinIdGenerator;
import com.bytedance.juejin.module.pin.domain.pin.view.PinCreateCommand;
import com.github.linyuzai.domain.mbp.MBPDomainIdGenerator;
import org.springframework.stereotype.Component;

/**
 * 基于 MBP id 生成器 的 沸点 id 生成器
 */
@Component
public class MBPPinIdGenerator extends MBPDomainIdGenerator<PinCreateCommand> implements PinIdGenerator {
}
