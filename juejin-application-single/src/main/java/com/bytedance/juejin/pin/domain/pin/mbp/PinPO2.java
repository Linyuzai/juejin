package com.bytedance.juejin.pin.domain.pin.mbp;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 沸点数据模型 v2
 */
@TableName("t_pin")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
class PinPO2 extends PinPO {

    /**
     * 地理位置
     */
    private String location;
}
