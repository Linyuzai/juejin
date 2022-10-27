package com.bytedance.juejin.pin.domain.club.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MBPClubRepository extends MBPDomainRepository<Club,ClubPO> implements ClubRepository {

    @Autowired
    private ClubMapper clubMapper;

    @Override
    public ClubPO do2po(Club object) {
        return null;
    }

    @Override
    public Club po2do(ClubPO object) {
        return null;
    }

    @Override
    public BaseMapper<ClubPO> getBaseMapper() {
        return clubMapper;
    }
}
