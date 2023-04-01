package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PinsImpl extends AbstractDomainCollection<Pin> implements Pins {

    protected PinsImpl(Object owner, Map<String, Pin> pins) {
        super(owner, pins);
    }

    public static class Builder extends AbstractDomainCollection.Builder<Pin, PinsImpl, Builder> {

        @Override
        protected PinsImpl doBuild() {
            return new PinsImpl(owner, getObjectMap());
        }
    }
}
