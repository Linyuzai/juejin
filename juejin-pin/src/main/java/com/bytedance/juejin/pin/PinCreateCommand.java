package com.bytedance.juejin.pin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "沸点创建命令")
public class PinCreateCommand {

    @Schema(description = "沸点内容")
    private String content;

    @Schema(description = "沸点圈子ID")
    private String clubId;
}
