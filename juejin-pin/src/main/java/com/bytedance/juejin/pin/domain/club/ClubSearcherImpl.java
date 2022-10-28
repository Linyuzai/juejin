package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 圈子搜索实现
 */
@Component
public class ClubSearcherImpl implements ClubSearcher {

    /**
     * 圈子存储
     */
    @Autowired
    private ClubRepository clubRepository;

    /**
     * 圈子模型与视图的转换适配器
     */
    @Autowired
    private ClubFacadeAdapter clubFacadeAdapter;

    /**
     * 根据 id 查询圈子视图
     */
    @Override
    public ClubVO get(String id) {
        return clubFacadeAdapter.do2vo(clubRepository.get(id));
    }

    /**
     * 条件查询圈子列表
     */
    @Override
    public List<ClubVO> list(ClubQuery query) {
        return clubRepository.list(clubFacadeAdapter.toConditions(query))
                .stream()
                .map(clubFacadeAdapter::do2vo)
                .collect(Collectors.toList());
    }
}
