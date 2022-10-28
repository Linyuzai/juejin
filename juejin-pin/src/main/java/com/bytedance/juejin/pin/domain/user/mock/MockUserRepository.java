package com.bytedance.juejin.pin.domain.user.mock;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mock.MockDomainRepository;
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
        UserImpl user = new UserImpl.Builder()
                .id("1")
                .name("admin")
                .clubs()
                .pins()
                .validator(validator)
                .build();
        map.put(user.getId(), user);
    }
}
