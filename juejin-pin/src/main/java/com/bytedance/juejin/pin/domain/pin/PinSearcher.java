package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.page.PageQuery;
import com.bytedance.juejin.basic.page.PageVO;
import com.bytedance.juejin.pin.domain.pin.view.PinSnapshotVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;

public interface PinSearcher {

    PinVO get(String id);

    PageVO<PinSnapshotVO> page(PageQuery page);

}
