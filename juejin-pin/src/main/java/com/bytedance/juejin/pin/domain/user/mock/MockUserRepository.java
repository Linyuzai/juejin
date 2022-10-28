package com.bytedance.juejin.pin.domain.user.mock;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mock.MockDomainRepository;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerUserClubs;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerUserPins;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserImpl;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MockUserRepository extends MockDomainRepository<User> implements UserRepository {

    private final Map<String, User> map = new ConcurrentHashMap<>();

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Override
    public Map<String, User> getMockMap() {
        return map;
    }

    @PostConstruct
    public void initUser() {
        String userId = "1";
        String userName = "管理员";
        UserImpl user = new UserImpl.Builder()
                .id(userId)
                .name(userName)
                .clubs(new SchrodingerUserClubs.Builder()
                        .userId(userId)
                        .context(context)
                        .validator(validator)
                        .build())
                .pins(new SchrodingerUserPins.Builder()
                        .userId(userId)
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
        map.put(user.getId(), user);
    }
}
