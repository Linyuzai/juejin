package com.bytedance.juejin.pin.domain.pin.impl.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.pin.Pin;
import org.springframework.beans.factory.annotation.Autowired;

public class MBPPinRepository extends MBPDomainRepository<Pin, PinPO> {

    @Autowired
    private PinMapper pinMapper;

    @Override
    public PinPO do2po(Pin pin) {
        return null;
    }

    @Override
    public Pin po2do(PinPO po) {
        return null;
    }

    @Override
    public BaseMapper<PinPO> getBaseMapper() {
        return pinMapper;
    }
}
