package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import com.bytedance.juejin.user.domain.user.view.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeAdapterImpl implements UserFacadeAdapter {

    @Autowired
    private UserInstantiator userInstantiator;

    @Override
    public UserVO do2vo(User user) {
        UserVO vo = userInstantiator.newView();
        vo.setId(user.getId());
        vo.setName(user.getName());
        vo.setProfilePicture(user.getProfilePicture());
        return vo;
    }

    @Override
    public UserRO do2ro(User user) {
        UserRO vo = userInstantiator.newRemote();
        vo.setId(user.getId());
        vo.setName(user.getName());
        vo.setProfilePicture(user.getProfilePicture());
        return vo;
    }
}
