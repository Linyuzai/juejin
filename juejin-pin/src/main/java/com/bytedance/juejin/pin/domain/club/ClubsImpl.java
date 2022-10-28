package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubsImpl extends AbstractDomainCollection<Club> implements Clubs {

    protected ClubsImpl(Object owner, Map<String, Club> clubs) {
        super(owner, clubs);
    }

    public static class Builder extends AbstractDomainCollection.Builder<Club, ClubsImpl, Builder> {

        @Override
        protected ClubsImpl doBuild() {
            return new ClubsImpl(owner, getObjectMap());
        }
    }
}
