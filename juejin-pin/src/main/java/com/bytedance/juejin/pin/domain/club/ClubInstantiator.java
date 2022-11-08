package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerUserClubs;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;

public interface ClubInstantiator {

    ClubImpl.Builder newBuilder();

    SchrodingerClub.Builder newSchrodingerBuilder();

    SchrodingerUserClubs.Builder newSchrodingerCollectionBuilderOwnedUser();

    ClubVO newView();
}
