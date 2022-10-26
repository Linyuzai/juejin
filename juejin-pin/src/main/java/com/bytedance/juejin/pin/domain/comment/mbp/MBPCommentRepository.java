package com.bytedance.juejin.pin.domain.comment.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
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
}
