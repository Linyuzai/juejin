package com.bytedance.juejin.rpc;

import com.github.linyuzai.domain.core.DomainObject;
import com.github.linyuzai.domain.core.Identifiable;
import com.github.linyuzai.domain.core.condition.Conditions;

public interface RemoteObjectFacadeAdapter<T extends DomainObject, R extends Identifiable> {

    R do2ro(T object);

    T ro2do(R ro);

    default ConditionsRO conditions2ro(Conditions conditions) {
        return new ConditionsRO();
    }

    default Conditions ro2conditions(ConditionsRO ro) {
        return new Conditions();
    }
}
