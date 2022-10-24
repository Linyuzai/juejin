package com.bytedance.juejin.pin.domain.comment.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.condition.Conditions;
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
    public CommentPO do2po(Comment object) {
        return null;
    }

    @Override
    public Comment po2do(CommentPO object) {
        return null;
    }

    @Override
    public BaseMapper<CommentPO> getBaseMapper() {
        return commentMapper;
    }

    @Override
    public void delete(Comments comments) {

    }

    @Override
    public long count(String pinId) {
        Conditions conditions = new Conditions().equal("pinId", pinId);
        return count(conditions);
    }

    @Override
    public long count(String pinId, String commentId) {
        Conditions conditions = new Conditions()
                .equal("pinId", pinId)
                .equal("commentId", commentId);
        return count(conditions);
    }
}
