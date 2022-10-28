package com.bytedance.juejin.pin.domain.pin.mbp;

import com.bytedance.juejin.basic.domain.mbp.MBPDomainIdGenerator;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class MBPPinIdGenerator extends MBPDomainIdGenerator<Pin> implements PinIdGenerator {
}
