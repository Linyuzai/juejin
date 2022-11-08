package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerUserClubs;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import org.springframework.stereotype.Component;

@Component
public class ClubInstantiatorImpl implements ClubInstantiator {

    @Override
    public ClubImpl.Builder newBuilder() {
        return new ClubImpl.Builder();
    }

    @Override
    public SchrodingerClub.Builder newSchrodingerBuilder() {
        return new SchrodingerClub.Builder();
    }

    @Override
    public SchrodingerUserClubs.Builder newSchrodingerCollectionBuilderOwnedUser() {
        return new SchrodingerUserClubs.Builder();
    }

    @Override
    public ClubVO newView() {
        return new ClubVO();
    }
}
