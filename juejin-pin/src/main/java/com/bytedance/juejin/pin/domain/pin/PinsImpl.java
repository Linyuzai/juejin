package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import com.bytedance.juejin.basic.exception.JuejinCanNotHappenException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PinsImpl extends AbstractDomainCollection<Pin> implements Pins {

    protected PinsImpl(Object owner) {
        this.owner = owner;
    }

    @Override
    public Object doGetOwner() {
        throw new JuejinCanNotHappenException();
    }

    @Override
    public Pin doGet(String id) {
        throw new JuejinNotFoundException(Pin.class, id);
    }

    public static class Builder extends AbstractDomainCollection.Builder<PinsImpl, Builder> {

        @Override
        protected PinsImpl doBuild() {
            return new PinsImpl(owner);
        }
    }
}
