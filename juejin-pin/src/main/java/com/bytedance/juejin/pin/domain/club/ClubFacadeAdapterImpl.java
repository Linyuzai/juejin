package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubUpdateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerClubPins;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerClubUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClubFacadeAdapterImpl implements ClubFacadeAdapter {

    @Autowired
    private ClubIdGenerator clubIdGenerator;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Override
    public Club from(ClubCreateCommand create, User user) {
        String id = clubIdGenerator.generateId(Club.class);
        return new ClubImpl.Builder()
                .id(id)
                .name(create.getName())
                .logo(create.getLogo())
                .category(create.getCategory())
                .description(create.getDescription())
                .announcement(create.getAnnouncement())
                .users(new SchrodingerClubUsers.Builder()
                        .clubId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .pins(new SchrodingerClubPins.Builder()
                        .clubId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    public Club from(ClubUpdateCommand update, Club old, User user) {
        return null;
    }

    @Override
    public ClubVO do2vo(Club pin) {
        return null;
    }

    @Override
    public Conditions toConditions(ClubQuery query) {
        return null;
    }
}
