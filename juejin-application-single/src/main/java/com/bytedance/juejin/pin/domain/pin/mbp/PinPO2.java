package com.bytedance.juejin.pin.domain.pin.mbp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
class PinPO2 extends PinPO {

    private String location;
}
