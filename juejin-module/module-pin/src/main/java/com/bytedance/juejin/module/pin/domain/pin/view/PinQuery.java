package com.bytedance.juejin.module.pin.domain.pin.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "沸点查询命令")
public class PinQuery {

    @Schema(description = "用户ID")
    private String userId;
}
