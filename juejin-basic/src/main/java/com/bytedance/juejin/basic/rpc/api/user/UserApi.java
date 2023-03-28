package com.bytedance.juejin.basic.rpc.api.user;

public interface UserApi {

    /**
     * 通过id获得用户信息
     */
    UserRO get(String id);
}
