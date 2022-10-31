package com.bytedance.juejin.pin.domain.like.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MBPLikeRepository extends MBPDomainRepository<Like,LikePO> implements LikeRepository {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public LikePO do2po(Like like) {
        return null;
    }

    @Override
    public Like po2do(LikePO po) {
        return null;
    }

    @Override
    public BaseMapper<LikePO> getBaseMapper() {
        return likeMapper;
    }
}
