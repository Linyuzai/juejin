package com.bytedance.juejin.module.pin.domain.club.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "沸点圈子更新命令")
public class ClubUpdateCommand {

    @Schema(description = "圈子ID")
    private String id;

    @Schema(description = "圈子名称")
    private String name;

    @Schema(description = "圈子图标")
    private String logo;

    @Schema(description = "圈子类别")
    private String category;

    @Schema(description = "圈子描述")
    private String description;
}
