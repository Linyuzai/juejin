package com.bytedance.juejin.basic.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Schema(description = "分页视图")
public class PageVO<T> {

    @Schema(description = "分页视图")
    private List<T> records = Collections.emptyList();

    @Schema(description = "总数")
    private long total = 0;

    @Schema(description = "每页数量")
    private long size = 10;

    @Schema(description = "当前页数")
    private long current = 1;

    @Schema(description = "总页数")
    private long pages = 1;
}
