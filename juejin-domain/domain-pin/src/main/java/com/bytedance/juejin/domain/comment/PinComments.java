package com.bytedance.juejin.domain.comment;

import java.util.List;

public interface PinComments extends Comments<PinComment> {

    /**
     * 获得最新的 n 条评论
     */
    List<PinComment> getNewestList(int count);
}
