package com.bytedance.juejin.pin.domain.pin.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "沸点视图")
public class PinVO {

    @Schema(description = "沸点ID")
    private String id;

    @Schema(description = "沸点内容")
    private String content;

    @Schema(description = "沸点圈子ID")
    private String clubId;

    @Schema(description = "沸点圈子名称")
    private String clubName;

    //点赞和评论的数据先省略
}
