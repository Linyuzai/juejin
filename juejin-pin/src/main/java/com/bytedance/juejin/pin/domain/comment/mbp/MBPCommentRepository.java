package com.bytedance.juejin.pin.domain.comment.mbp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 基于 MyBatis-Plus 的评论存储实现
 */
@Repository
public class MBPCommentRepository extends MBPDomainRepository<Comment, CommentPO> implements CommentRepository {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public CommentPO do2po(Comment comment) {
        return null;
    }

    @Override
    public Comment po2do(CommentPO po) {
        return null;
    }

    @Override
    public BaseMapper<CommentPO> getBaseMapper() {
        return commentMapper;
    }

    @Override
    public void delete(Comments comments) {
        String pinId = comments.getPin().getId();
        Wrapper<CommentPO> wrapper = Wrappers.<CommentPO>lambdaQuery()
                .eq(CommentPO::getPinId, pinId);
        getBaseMapper().delete(wrapper);
    }

    @Override
    public long count(String pinId) {
        Wrapper<CommentPO> wrapper = Wrappers.<CommentPO>lambdaQuery()
                .eq(CommentPO::getPinId, pinId);
        return getBaseMapper().selectCount(wrapper);
    }

    @Override
    public long count(String pinId, String commentId) {
        Wrapper<CommentPO> wrapper = Wrappers.<CommentPO>lambdaQuery()
                .eq(CommentPO::getPinId, pinId)
                .eq(CommentPO::getCommentId, commentId);
        return getBaseMapper().selectCount(wrapper);
    }
}
