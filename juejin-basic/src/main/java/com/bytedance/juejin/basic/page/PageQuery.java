package com.bytedance.juejin.basic.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "分页参数")
public class PageQuery {

    @Schema(description = "当前页数")
    private long current = 1;

    @Schema(description = "每页数量")
    private long size = 10;
}
