package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import com.bytedance.juejin.basic.exception.JuejinCanNotHappenException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UsersImpl extends AbstractDomainCollection<User> implements Users {

    protected UsersImpl(Object owner) {
        this.owner = owner;
    }

    @Override
    public Object doGetOwner() {
        throw new JuejinCanNotHappenException();
    }

    @Override
    public User doGet(String id) {
        throw new JuejinNotFoundException(User.class, id);
    }

    public static class Builder extends AbstractDomainCollection.Builder<UsersImpl, Builder> {

        @Override
        protected UsersImpl doBuild() {
            return new UsersImpl(owner);
        }
    }
}
