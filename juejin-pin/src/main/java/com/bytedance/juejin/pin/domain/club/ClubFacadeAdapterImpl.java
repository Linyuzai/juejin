package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubUpdateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class ClubFacadeAdapterImpl implements ClubFacadeAdapter {

    @Override
    public Club from(ClubCreateCommand create, User user) {
        return null;
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
