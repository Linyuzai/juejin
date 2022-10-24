package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.page.Pages;
import com.bytedance.juejin.pin.domain.pin.view.PinSnapshotVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;

public interface PinSearcher {

    PinVO get(String id);

    Pages<PinSnapshotVO> page(Pages.Args page);

}
