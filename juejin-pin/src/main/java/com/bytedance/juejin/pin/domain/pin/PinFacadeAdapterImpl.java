package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerPinComments;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerPinLikes;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinQuery;
import com.bytedance.juejin.pin.domain.pin.view.PinSnapshotVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 沸点领域模型和视图的转换适配器
 */
@Component
public class PinFacadeAdapterImpl implements PinFacadeAdapter {

    @Autowired
    private PinIdGenerator pinIdGenerator;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Override
    public Pin from(PinCreateCommand create, User user) {
        String id = pinIdGenerator.generateId(Pin.class);
        return new PinImpl.Builder()
                .id(id)
                .content(create.getContent())
                .club(getClub(create.getClubId()))
                .user(user)
                .comments(new SchrodingerPinComments.Builder()
                        .pinId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .likes(new SchrodingerPinLikes.Builder()
                        .pinId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    public PinVO do2vo(Pin pin) {
        return null;
    }

    @Override
    public Conditions toConditions(PinQuery query) {
        return null;
    }

    @Override
    public PinSnapshotVO toSnapshot(Pin pin) {
        return null;
    }

    /**
     * 获得圈子领域模型
     */
    public Club getClub(String clubId) {
        if (clubId == null) {
            return null;
        }
        //返回薛定谔的圈子模型
        return new SchrodingerClub.Builder()
                .id(clubId)
                .context(context)
                .validator(validator)
                .build();
    }
}
