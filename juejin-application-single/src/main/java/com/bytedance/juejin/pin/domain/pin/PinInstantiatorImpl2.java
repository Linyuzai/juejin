package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin2;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO2;

public class PinInstantiatorImpl2 extends PinInstantiatorImpl {

    @Override
    public PinImpl.Builder newBuilder() {
        return new PinImpl2.Builder();
    }

    @Override
    public SchrodingerPin.Builder newSchrodingerBuilder() {
        return new SchrodingerPin2.Builder();
    }

    @Override
    public PinVO newView() {
        return new PinVO2();
    }
}
