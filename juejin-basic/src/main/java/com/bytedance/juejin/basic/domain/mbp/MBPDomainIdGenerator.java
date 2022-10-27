package com.bytedance.juejin.basic.domain.mbp;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.bytedance.juejin.basic.domain.DomainIdGenerator;
import com.bytedance.juejin.basic.domain.DomainObject;

public abstract class MBPDomainIdGenerator<T extends DomainObject> implements DomainIdGenerator<T> {

    @Override
    public String generateId(Class<T> domainClass) {
        return IdWorker.getIdStr();
    }
}
