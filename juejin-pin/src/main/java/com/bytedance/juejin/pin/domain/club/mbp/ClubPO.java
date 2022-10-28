package com.bytedance.juejin.pin.domain.club.mbp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 圈子数据模型
 */
@Data
@TableName("t_pin_club")
public class ClubPO {

    /**
     * 圈子ID
     */
    @TableId(type = IdType.INPUT)
    private String id;

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
