package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.page.Pages;
import com.bytedance.juejin.pin.domain.pin.view.PinQuery;
import com.bytedance.juejin.pin.domain.pin.view.PinSnapshotVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 沸点查询器
 */
@Component
public class PinSearcherImpl implements PinSearcher {

    /**
     * 沸点存储
     */
    @Autowired
    private PinRepository pinRepository;

    /**
     * 沸点模型与视图转换适配器
     */
    @Autowired
    private PinFacadeAdapter pinFacadeAdapter;

    /**
     * 根据 id 获得沸点视图
     */
    @Override
    public PinVO get(String id) {
        return pinFacadeAdapter.do2vo(pinRepository.get(id));
    }

    /**
     * 分页获得沸点快照
     */
    @Override
    public Pages<PinSnapshotVO> page(PinQuery query, Pages.Args page) {
        return pinRepository
                .page(pinFacadeAdapter.toConditions(query), page)
                .map(pinFacadeAdapter::toSnapshot);
    }
}
