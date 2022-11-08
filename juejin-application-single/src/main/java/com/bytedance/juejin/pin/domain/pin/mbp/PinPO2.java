package com.bytedance.juejin.pin.domain.pin.mbp;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@TableName("t_pin")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
class PinPO2 extends PinPO {

    private String location;
}
