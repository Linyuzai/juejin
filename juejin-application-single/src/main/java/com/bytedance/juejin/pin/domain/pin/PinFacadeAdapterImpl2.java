package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand2;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO2;

public class PinFacadeAdapterImpl2 extends PinFacadeAdapterImpl {

    @Override
    protected void postBuilder(PinImpl.Builder builder, PinCreateCommand create) {
        ((PinImpl2.Builder) builder).location(((PinCreateCommand2) create).getLocation());
    }

    @Override
    public PinVO do2vo(Pin pin) {
        PinVO vo = super.do2vo(pin);
        ((PinVO2) vo).setLocation(((Pin2) pin).getLocation());
        return vo;
    }
}
