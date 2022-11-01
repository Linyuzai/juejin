package com.bytedance.juejin.pin.domain.club.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubImpl;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerClubPins;
import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerClubUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 圈子存储
 */
@Repository
public class MBPClubRepository extends MBPDomainRepository<Club, ClubPO> implements ClubRepository {

    @Autowired
    private ClubMapper clubMapper;

    /**
     * 领域上下文
     */
    @Autowired
    private DomainContext context;

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
        return new ClubImpl.Builder()
                .id(po.getId())
                .name(po.getName())
                .logo(po.getLogo())
                .category(po.getCategory())
                .description(po.getDescription())
                .announcement(po.getAnnouncement())
                .users(new SchrodingerClubUsers.Builder()
                        .clubId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .pins(new SchrodingerClubPins.Builder()
                        .clubId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    public Class<ClubPO> getFetchClass() {
        return ClubPO.class;
    }

    @Override
    public BaseMapper<ClubPO> getBaseMapper() {
        return clubMapper;
    }
}
