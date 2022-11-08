package com.bytedance.juejin.pin.domain.pin.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 沸点视图 v2
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PinVO2 extends PinVO {

    @Schema(description = "地理位置")
    private String location;
}
