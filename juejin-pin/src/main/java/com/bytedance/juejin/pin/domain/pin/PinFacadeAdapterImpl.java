package com.bytedance.juejin.pin.domain.pin;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinFacadeAdapter;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PinFacadeAdapterImpl implements PinFacadeAdapter {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public Pin from(PinCreateCommand create, User user) {
        return new Pin.Builder()
                .id(generateId())
                .content(create.getContent())
                .club(getClub(create.getClubId()))
                .user(user)
                .build();
    }

    public Club getClub(String clubId) {
        if (clubId == null) {
            return null;
        }
        return new SchrodingerClub.Builder()
                .id(clubId)
                .clubRepository(clubRepository)
                .build();
    }

    public String generateId() {
        return IdWorker.getIdStr();
    }
}
