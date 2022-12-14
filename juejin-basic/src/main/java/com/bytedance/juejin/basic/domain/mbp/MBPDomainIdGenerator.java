package com.bytedance.juejin.basic.domain.mbp;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.bytedance.juejin.basic.domain.DomainIdGenerator;
import com.bytedance.juejin.basic.domain.DomainObject;

/**
 * 基于 MyBatis-Plus 的 id 生成器
 *
 * @param <T>
 */
public abstract class MBPDomainIdGenerator<T extends DomainObject> implements DomainIdGenerator<T> {

    @Override
    public String generateId(Class<T> domainClass) {
        return IdWorker.getIdStr();
    }
}
