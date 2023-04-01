package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;

import java.util.List;

/**
 * 圈子搜索
 */
public interface ClubSearcher {

    /**
     * 根据 id 查询圈子视图
     */
    ClubVO get(String id);

    /**
     * 条件查询圈子列表
     */
    List<ClubVO> list(ClubQuery query);
}
