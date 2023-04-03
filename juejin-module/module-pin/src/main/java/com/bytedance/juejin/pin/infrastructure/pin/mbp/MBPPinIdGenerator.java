package com.bytedance.juejin.pin.infrastructure.pin.mbp;

import com.bytedance.juejin.pin.domain.pin.PinIdGenerator;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.github.linyuzai.domain.mbp.MBPDomainIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class MBPPinIdGenerator extends MBPDomainIdGenerator<PinCreateCommand> implements PinIdGenerator {
}
