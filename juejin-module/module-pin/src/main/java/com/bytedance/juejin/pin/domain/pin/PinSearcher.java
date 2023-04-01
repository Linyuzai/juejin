package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.page.Pages;
import com.bytedance.juejin.pin.domain.pin.view.PinQuery;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;

/**
 * 沸点搜索器
 */
public interface PinSearcher {

    PinVO get(String id);

    Pages<PinVO> page(PinQuery query, Pages.Args page);

}
