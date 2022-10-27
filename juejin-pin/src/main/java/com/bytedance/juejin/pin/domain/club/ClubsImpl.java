package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import com.bytedance.juejin.basic.exception.JuejinCanNotHappenException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubsImpl extends AbstractDomainCollection<Club> implements Clubs {

    protected ClubsImpl(Object owner) {
        this.owner = owner;
    }

    @Override
    public Object doGetOwner() {
        throw new JuejinCanNotHappenException();
    }

    @Override
    public Club doGet(String id) {
        throw new JuejinNotFoundException(Club.class, id);
    }

    public static class Builder extends AbstractDomainCollection.Builder<ClubsImpl, Builder> {

        @Override
        protected ClubsImpl doBuild() {
            return new ClubsImpl(owner);
        }
    }
}
