package com.bytedance.juejin.pin.domain.pin.mbp;

import lombok.Data;

import java.util.Date;

@Data
public class PinPO {

    private String id;

    private String content;

    private String clubId;

    private String userId;

    private Date createTime;
}
