package com.bytedance.juejin.basic.rpc.api.user;

import com.bytedance.juejin.basic.domain.IdProvider;
import lombok.Data;

@Data
public class UserRO implements IdProvider {

    private String id;

    private String name;

    private String profilePicture;
}
