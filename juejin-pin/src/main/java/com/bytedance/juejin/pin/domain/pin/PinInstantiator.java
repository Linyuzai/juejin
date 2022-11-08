package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerClubPins;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerUserPins;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;

public interface PinInstantiator {

    PinImpl.Builder newBuilder();

    SchrodingerPin.Builder newSchrodingerBuilder();

    SchrodingerClubPins.Builder newSchrodingerCollectionBuilderOwnedClub();

    SchrodingerUserPins.Builder newSchrodingerCollectionBuilderOwnedUser();

    PinVO newView();
}
