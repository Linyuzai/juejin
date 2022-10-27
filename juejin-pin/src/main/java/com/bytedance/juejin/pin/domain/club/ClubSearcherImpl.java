package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClubSearcherImpl implements ClubSearcher {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ClubFacadeAdapter clubFacadeAdapter;

    @Override
    public ClubVO get(String id) {
        return clubFacadeAdapter.do2vo(clubRepository.get(id));
    }

    @Override
    public List<ClubVO> list(ClubQuery query) {
        return clubRepository.list(clubFacadeAdapter.toConditions(query))
                .stream()
                .map(clubFacadeAdapter::do2vo)
                .collect(Collectors.toList());
    }
}
