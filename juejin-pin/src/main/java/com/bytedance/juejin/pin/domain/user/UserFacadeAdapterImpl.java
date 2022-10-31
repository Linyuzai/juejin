package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.pin.domain.user.view.UserVO;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeAdapterImpl implements UserFacadeAdapter {

    @Override
    public UserVO do2vo(User user) {
        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setName(user.getName());
        vo.setProfilePicture(user.getProfilePicture());
        return vo;
    }
}
