package com.bytedance.juejin.user.domain.user.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.user.domain.user.User;
import com.bytedance.juejin.user.domain.user.UserImpl;
import com.bytedance.juejin.user.domain.user.UserInstantiator;
import com.bytedance.juejin.user.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 基于 MyBatis-Plus 的用户存储实现
 */
@Repository
@SuppressWarnings("unchecked")
public class MBPUserRepository<P extends UserPO> extends MBPDomainRepository<User, P> implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DomainValidator validator;

    @Autowired
    private UserInstantiator userInstantiator;

    @Override
    public P do2po(User user) {
        P po = newPO();
        po.setId(user.getId());
        po.setName(user.getName());
        po.setProfilePicture(user.getProfilePicture());
        return po;
    }

    protected P newPO() {
        return (P) new UserPO();
    }

    @Override
    public User po2do(P po) {
        UserImpl.Builder builder = userInstantiator.newBuilder()
                .id(po.getId())
                .name(po.getName())
                .profilePicture(po.getProfilePicture())
                .validator(validator);
        beforeBuild(builder, po);
        return builder.build();
    }

    protected void beforeBuild(UserImpl.Builder builder, P po) {

    }

    @Override
    public Class<P> getFetchClass() {
        return (Class<P>) UserPO.class;
    }

    @Override
    public BaseMapper<P> getBaseMapper() {
        return (BaseMapper<P>) userMapper;
    }
}
