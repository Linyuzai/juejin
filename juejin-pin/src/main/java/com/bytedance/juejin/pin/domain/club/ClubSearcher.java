package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;

import java.util.List;

public interface ClubSearcher {

    ClubVO get(String id);

    List<ClubVO> list(ClubQuery query);
}
