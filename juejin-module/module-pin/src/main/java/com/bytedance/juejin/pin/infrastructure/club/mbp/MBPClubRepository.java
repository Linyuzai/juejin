package com.bytedance.juejin.pin.infrastructure.club.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bytedance.juejin.domain.club.Club;
import com.bytedance.juejin.domain.club.ClubImpl;
import com.bytedance.juejin.domain.club.ClubRepository;
import com.bytedance.juejin.domain.club.Clubs;
import com.bytedance.juejin.domain.user.Users;
import com.github.linyuzai.domain.core.DomainFactory;
import com.github.linyuzai.domain.core.DomainValidator;
import com.github.linyuzai.domain.mbp.MBPDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 圈子存储
 */
@Repository
public class MBPClubRepository extends MBPDomainRepository<Club, Clubs, ClubPO> implements ClubRepository {

    /**
     * 圈子 Mapper
     */
    @Autowired
    private ClubMapper clubMapper;

    @Autowired
    private ClubUserMapper clubUserMapper;

    @Autowired
    private DomainFactory factory;

    /**
     * 领域校验器
     */
    @Autowired
    private DomainValidator validator;

    /**
     * 领域模型转数据模型
     */
    @Override
    public ClubPO do2po(Club club) {
        ClubPO po = new ClubPO();
        po.setId(club.getId());
        po.setName(club.getName());
        po.setLogo(club.getLogo());
        po.setCategory(club.getCategory());
        po.setDescription(club.getDescription());
        po.setAnnouncement(club.getAnnouncement());
        return po;
    }

    /**
     * 数据模型转领域模型
     */
    @Override
    public Club po2do(ClubPO po) {
        List<ClubUserPO> pos = clubUserMapper.selectList(Wrappers.<ClubUserPO>lambdaQuery()
                .eq(ClubUserPO::getClubId, po.getId()));
        Users users;
        if (pos.isEmpty()) {
            users = factory.createCollection(Users.class, Collections.emptyList());
        } else {
            Set<String> userIds = pos.stream()
                    .map(ClubUserPO::getUserId)
                    .collect(Collectors.toSet());
            users = factory.createCollection(Users.class, userIds, false);
        }
        return new ClubImpl.Builder()
                .id(po.getId())
                .name(po.getName())
                .logo(po.getLogo())
                .category(po.getCategory())
                .description(po.getDescription())
                .announcement(po.getAnnouncement())
                .users(users)
                .build(validator);
    }

    @Override
    public BaseMapper<ClubPO> getBaseMapper() {
        return clubMapper;
    }
}
