package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.domain.pin.Pin;
import com.bytedance.juejin.domain.pin.PinRepository;
import com.bytedance.juejin.pin.domain.pin.view.PinQuery;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.github.linyuzai.domain.core.page.Pages;
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
        Pin pin = pinRepository.get(id);
        if (pin == null) {
            return null;
        }
        return pinFacadeAdapter.do2vo(pin);
    }

    /**
     * 分页获得沸点
     */
    @Override
    public Pages<PinVO> page(PinQuery query, Pages.Args page) {
        return pinRepository
                .page(pinFacadeAdapter.toConditions(query), page)
                .map(pinFacadeAdapter::do2vo);
    }
}
