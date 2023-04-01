package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerClubPins;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerUserPins;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;

/**
 * 沸点实例化器
 */
public interface PinInstantiator {

    /**
     * 实例化普通的 Builder
     */
    PinImpl.Builder newBuilder();

    /**
     * 实例化薛定谔的 Builder
     */
    SchrodingerPin.Builder newSchrodingerBuilder();

    SchrodingerClubPins.Builder newSchrodingerCollectionBuilderOwnedClub();

    SchrodingerUserPins.Builder newSchrodingerCollectionBuilderOwnedUser();

    /**
     * 实例化视图
     */
    PinVO newView();
}
