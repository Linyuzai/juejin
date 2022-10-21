package com.bytedance.juejin.pin.domain.pin.impl.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.pin.Pin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MBPPinRepository extends MBPDomainRepository<Pin, PinPO> {

    @Autowired
    private PinMapper pinMapper;

    @Override
    public PinPO do2po(Pin pin) {
        PinPO po = new PinPO();
        po.setId(pin.getId());
        po.setContent(pin.getContent());
        po.setClubId(pin.getClub().getId());
        po.setUserId(pin.getUser().getId());
        po.setCreateTime(new Date(pin.getCreateTime()));
        return po;
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
