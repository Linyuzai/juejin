package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.page.Pages;
import com.bytedance.juejin.pin.domain.comment.view.CommentQuery;
import com.bytedance.juejin.pin.domain.comment.view.CommentVO;

/**
 * 评论搜索器
 */
public interface CommentSearcher {

    Pages<CommentVO> page(CommentQuery query, Pages.Args page);
}
