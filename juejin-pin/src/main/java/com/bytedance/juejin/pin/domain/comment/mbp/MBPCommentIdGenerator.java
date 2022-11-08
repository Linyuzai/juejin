package com.bytedance.juejin.pin.domain.comment.mbp;

import com.bytedance.juejin.basic.domain.mbp.MBPDomainIdGenerator;
import com.bytedance.juejin.pin.domain.comment.Comment;
import com.bytedance.juejin.pin.domain.comment.CommentIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class MBPCommentIdGenerator extends MBPDomainIdGenerator<Comment> implements CommentIdGenerator {
}
