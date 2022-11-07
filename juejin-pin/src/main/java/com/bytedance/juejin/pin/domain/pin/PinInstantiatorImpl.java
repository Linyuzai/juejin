package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import org.springframework.stereotype.Component;

@Component
public class PinInstantiatorImpl implements PinInstantiator {

    @Override
    public PinImpl.Builder newBuilder() {
        return new PinImpl.Builder();
    }

    @Override
    public SchrodingerPin.Builder newSchrodingerBuilder() {
        return new SchrodingerPin.Builder();
    }

    @Override
    public PinVO newView() {
        return new PinVO();
    }
}
