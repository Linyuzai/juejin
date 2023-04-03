package com.bytedance.juejin.pin.domain.like.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "沸点点赞删除命令")
public class LikeDeleteCommand {

    /**
     * 可以通过拼接 pinId/commentId + userId
     */
    @Schema(description = "点赞ID")
    private String id;
}
