package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;

public interface PinInstantiator {

    PinImpl.Builder newBuilder();

    SchrodingerPin.Builder newSchrodingerBuilder();

    PinVO newView();
}
