package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand2;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO2;

/**
 * 沸点领域模型和视图的转换适配器 v2
 */
public class PinFacadeAdapterImpl2 extends PinFacadeAdapterImpl {

    /**
     * 在 build 之前设置 location
     */
    @Override
    protected void beforeBuild(PinImpl.Builder builder, PinCreateCommand create) {
        ((PinImpl2.Builder) builder).location(((PinCreateCommand2) create).getLocation());
    }

    /**
     * 给 vo 设置 location
     */
    @Override
    public PinVO do2vo(Pin pin) {
        PinVO vo = super.do2vo(pin);
        ((PinVO2) vo).setLocation(((Pin2) pin).getLocation());
        return vo;
    }
}
