package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UsersImpl extends AbstractDomainCollection<User> implements Users {

    protected UsersImpl(Object owner, Map<String, User> users) {
        super(owner, users);
    }

    public static class Builder extends AbstractDomainCollection.Builder<User, UsersImpl, Builder> {

        @Override
        protected UsersImpl doBuild() {
            return new UsersImpl(owner, getObjectMap());
        }
    }
}
