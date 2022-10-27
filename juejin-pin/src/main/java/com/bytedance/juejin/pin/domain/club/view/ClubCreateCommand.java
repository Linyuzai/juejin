package com.bytedance.juejin.pin.domain.club.view;

import lombok.Data;

@Data
public class ClubCreateCommand {

    /**
     * 圈子名称
     */
    private String name;

    /**
     * 圈子图标
     */
    private String logo;

    /**
     * 圈子类别
     */
    private String category;

    /**
     * 圈子描述
     */
    private String description;

    /**
     * 圈子公告
     */
    private String announcement;
}
