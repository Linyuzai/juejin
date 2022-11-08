package com.bytedance.juejin.pin.domain.pin.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.Pin2;
import com.bytedance.juejin.pin.domain.pin.PinImpl;
import com.bytedance.juejin.pin.domain.pin.PinImpl2;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基于 MyBatis-Plus 的沸点存储实现 v2
 */
public class MBPPinRepository2 extends MBPPinRepository<PinPO2> {

    @Autowired
    private PinMapper2 pinMapper2;

    /**
     * 给 po 设置 location
     */
    @Override
    public PinPO2 do2po(Pin pin) {
        PinPO2 po = super.do2po(pin);
        po.setLocation(((Pin2) pin).getLocation());
        return po;
    }

    /**
     * 创建 PinPO2
     */
    @Override
    protected PinPO2 newPO() {
        return new PinPO2();
    }

    /**
     * 在 build 之前设置 location
     */
    @Override
    protected void beforeBuild(PinImpl.Builder builder, PinPO2 po) {
        ((PinImpl2.Builder) builder).location(po.getLocation());
    }

    /**
     * 指定数据模型为 PinPO2
     */
    @Override
    public Class<PinPO2> getFetchClass() {
        return PinPO2.class;
    }

    /**
     * 返回 BaseMapper 为 PinMapper2
     */
    @Override
    public BaseMapper<PinPO2> getBaseMapper() {
        return pinMapper2;
    }
}
