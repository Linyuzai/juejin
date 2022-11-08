package com.bytedance.juejin.pin.domain.pin.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.comment.CommentInstantiator;
import com.bytedance.juejin.pin.domain.like.LikeInstantiator;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinImpl;
import com.bytedance.juejin.pin.domain.pin.PinInstantiator;
import com.bytedance.juejin.pin.domain.pin.PinRepository;
import com.bytedance.juejin.pin.domain.user.UserInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 基于 MyBatis-Plus 的沸点存储实现
 */
@Repository
@SuppressWarnings("unchecked")
public class MBPPinRepository<P extends PinPO> extends MBPDomainRepository<Pin, P> implements PinRepository {

    @Autowired
    private PinMapper pinMapper;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Autowired
    private PinInstantiator pinInstantiator;

    @Autowired
    private UserInstantiator userInstantiator;

    @Autowired
    private CommentInstantiator commentInstantiator;

    @Autowired
    private LikeInstantiator likeInstantiator;

    @Override
    public P do2po(Pin pin) {
        P po = newPO();
        po.setId(pin.getId());
        po.setContent(pin.getContent());
        if (pin.getClub() != null) {
            po.setClubId(pin.getClub().getId());
        }
        po.setUserId(pin.getUser().getId());
        po.setCreateTime(new Date(pin.getCreateTime()));
        return po;
    }

    protected P newPO() {
        return (P) new PinPO();
    }

    @Override
    public Pin po2do(P po) {
        Club club;
        String clubId = po.getClubId();
        if (clubId == null) {
            club = null;
        } else {
            club = new SchrodingerClub.Builder()
                    .id(po.getClubId())
                    .context(context)
                    .validator(validator)
                    .build();
        }
        PinImpl.Builder builder = pinInstantiator.newBuilder()
                .id(po.getId())
                .content(po.getContent())
                .club(club)
                .user(userInstantiator.newSchrodingerBuilder()
                        .id(po.getUserId())
                        .context(context)
                        .validator(validator)
                        .build())
                .comments(commentInstantiator.newSchrodingerCollectionBuilderOwnedPin()
                        .pinId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .likes(likeInstantiator.newSchrodingerCollectionBuilderOwnedPin()
                        .pinId(po.getId())
                        .context(context)
                        .validator(validator)
                        .build())
                .createTime(po.getCreateTime().getTime())
                .validator(validator);
        postBuilder(builder, po);
        return builder.build();
    }

    protected void postBuilder(PinImpl.Builder builder, P po) {

    }

    @Override
    public Class<P> getFetchClass() {
        return (Class<P>) PinPO.class;
    }

    @Override
    public BaseMapper<P> getBaseMapper() {
        return (BaseMapper<P>) pinMapper;
    }
}
