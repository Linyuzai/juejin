package com.bytedance.juejin.pin.domain.club.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubInstantiator;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.pin.PinInstantiator;
import com.bytedance.juejin.pin.domain.user.UserInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 圈子存储
 */
@Repository
@SuppressWarnings("unchecked")
public class MBPClubRepository<P extends ClubPO> extends MBPDomainRepository<Club, P> implements ClubRepository {

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

    @Autowired
    private ClubInstantiator clubInstantiator;

    @Autowired
    private PinInstantiator pinInstantiator;

    @Autowired
    private UserInstantiator userInstantiator;

    /**
     * 领域模型转数据模型
     */
    @Override
    public P do2po(Club club) {
        ClubPO po = new ClubPO();
        po.setId(club.getId());
        po.setName(club.getName());
        po.setLogo(club.getLogo());
        po.setCategory(club.getCategory());
        po.setDescription(club.getDescription());
        po.setAnnouncement(club.getAnnouncement());
        return (P) po;
    }

    /**
     * 数据模型转领域模型
     */
    @Override
    public Club po2do(ClubPO po) {
        return clubInstantiator.newBuilder()
                .id(po.getId())
                .name(po.getName())
                .logo(po.getLogo())
                .category(po.getCategory())
                .description(po.getDescription())
                .announcement(po.getAnnouncement())
                .users(userInstantiator.newSchrodingerCollectionBuilderOwnedClub()
                        .clubId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .pins(pinInstantiator.newSchrodingerCollectionBuilderOwnedClub()
                        .clubId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    public Class<P> getFetchClass() {
        return (Class<P>) ClubPO.class;
    }

    @Override
    public BaseMapper<P> getBaseMapper() {
        return (BaseMapper<P>) clubMapper;
    }
}
