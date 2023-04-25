package com.bytedance.juejin.rpc.feign.user;

import com.bytedance.juejin.rpc.Response;
import com.bytedance.juejin.rpc.user.RPCUserFacadeAdapter;
import com.bytedance.juejin.rpc.user.UserRO;
import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.domain.user.UserRepository;
import com.bytedance.juejin.domain.user.Users;
import com.github.linyuzai.domain.core.AbstractDomainRepository;
import com.github.linyuzai.domain.core.condition.Conditions;
import com.github.linyuzai.domain.core.page.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignUserRepository extends AbstractDomainRepository<User, Users, UserRO> implements UserRepository {

    @Autowired
    private RPCUserFacadeAdapter rpcUserFacadeAdapter;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserRO do2po(User user) {
        return rpcUserFacadeAdapter.do2ro(user);
    }

    @Override
    public User po2do(UserRO ro) {
        return rpcUserFacadeAdapter.ro2do(ro);
    }

    @Override
    protected void doCreate(UserRO po) {

    }

    @Override
    protected void doCreate(Collection<? extends UserRO> pos) {

    }

    @Override
    protected void doUpdate(UserRO po) {

    }

    @Override
    protected void doUpdate(Collection<? extends UserRO> pos) {

    }

    @Override
    protected void doDelete(UserRO po) {

    }

    @Override
    protected void doDelete(Collection<? extends UserRO> pos) {

    }

    @Override
    protected UserRO doGet(String id) {
        Response<UserRO> response = userFeignClient.get(id);
        if (response.isSuccess()) {
            return response.getObject();
        }
        throw new RuntimeException(response.getMessage());
    }

    @Override
    protected Collection<UserRO> doSelect(Collection<String> ids) {
        return null;
    }

    @Override
    protected void doDelete(Conditions conditions) {

    }

    @Override
    protected UserRO doGet(Conditions conditions) {
        return null;
    }

    @Override
    protected Collection<UserRO> doSelect(Conditions conditions) {
        return null;
    }

    @Override
    protected Long doCount(Conditions conditions) {
        return null;
    }

    @Override
    protected Pages<UserRO> doPage(Conditions conditions, Pages.Args page) {
        return null;
    }
}
