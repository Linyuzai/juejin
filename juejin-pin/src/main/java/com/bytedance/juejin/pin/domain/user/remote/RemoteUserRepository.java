package com.bytedance.juejin.pin.domain.user.remote;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.AbstractDomainRepository;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.page.Pages;
import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import com.bytedance.juejin.basic.rpc.api.user.UserApi;
import com.bytedance.juejin.pin.domain.club.ClubInstantiator;
import com.bytedance.juejin.pin.domain.pin.PinInstantiator;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserInstantiator;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class RemoteUserRepository extends AbstractDomainRepository<User, UserRO> implements UserRepository {

    @Autowired
    private UserApi userApi;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Autowired
    private UserInstantiator userInstantiator;

    @Autowired
    private ClubInstantiator clubInstantiator;

    @Autowired
    private PinInstantiator pinInstantiator;

    @Override
    public UserRO do2po(User object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User po2do(UserRO ro) {
        return userInstantiator.newBuilder()
                .id(ro.getId())
                .name(ro.getName())
                .profilePicture(ro.getProfilePicture())
                .clubs(clubInstantiator.newSchrodingerCollectionBuilderOwnedUser()
                        .userId(ro.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .pins(pinInstantiator.newSchrodingerCollectionBuilderOwnedUser()
                        .userId(ro.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    protected void doCreate(UserRO po) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doCreate(Collection<? extends UserRO> pos) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doUpdate(UserRO po) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doUpdate(Collection<? extends UserRO> pos) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doDelete(UserRO po) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doDelete(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doDelete(Collection<String> ids) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected UserRO doGet(String id) {
        return userApi.get(id);
    }

    @Override
    protected Collection<UserRO> doSelect(Collection<String> ids) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doDelete(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected UserRO doQuery(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Long doCount(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected List<UserRO> doList(Conditions conditions) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Pages<UserRO> doPage(Conditions conditions, Pages.Args page) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Stream<UserRO> doStream(Conditions conditions) {
        throw new UnsupportedOperationException();
    }
}
