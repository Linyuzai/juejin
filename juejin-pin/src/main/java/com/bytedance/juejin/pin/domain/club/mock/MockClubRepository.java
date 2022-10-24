package com.bytedance.juejin.pin.domain.club.mock;

import com.bytedance.juejin.basic.domain.mock.MockDomainRepository;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Map;

@Repository
public class MockClubRepository extends MockDomainRepository<Club> implements ClubRepository {

    @Override
    public Map<String, Club> getMockMap() {
        return Collections.emptyMap();
    }
}
