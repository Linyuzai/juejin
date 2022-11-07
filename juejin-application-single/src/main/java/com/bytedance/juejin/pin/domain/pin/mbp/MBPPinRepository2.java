package com.bytedance.juejin.pin.domain.pin.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.Pin2;
import com.bytedance.juejin.pin.domain.pin.PinImpl;
import com.bytedance.juejin.pin.domain.pin.PinImpl2;
import org.springframework.beans.factory.annotation.Autowired;

public class MBPPinRepository2 extends MBPPinRepository<PinPO2> {

    @Autowired
    private PinMapper2 pinMapper2;

    @Override
    public PinPO2 do2po(Pin pin) {
        PinPO2 po = super.do2po(pin);
        po.setLocation(((Pin2) pin).getLocation());
        return po;
    }

    @Override
    protected void postBuilder(PinImpl.Builder builder, PinPO2 po) {
        ((PinImpl2.Builder) builder).location(po.getLocation());
    }

    @Override
    public Class<PinPO2> getFetchClass() {
        return PinPO2.class;
    }

    @Override
    public BaseMapper<PinPO2> getBaseMapper() {
        return pinMapper2;
    }
}
