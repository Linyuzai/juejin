package com.bytedance.juejin.pin.domain.pin.mbp;

import lombok.Data;

import java.util.Date;

@Data
class PinPO {

    private String id;

    private String content;

    private String clubId;

    private String userId;

    private Date createTime;
}
