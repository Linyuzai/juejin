package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.login.Login;
import com.bytedance.juejin.basic.page.Pages;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.comment.view.CommentDeleteCommand;
import com.bytedance.juejin.pin.domain.comment.view.CommentQuery;
import com.bytedance.juejin.pin.domain.comment.view.CommentVO;
import com.bytedance.juejin.pin.domain.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "沸点评论")
@RestController
@RequestMapping("/pin-comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentSearcher commentSearcher;

    @Operation(summary = "添加评论")
    @PostMapping
    public void create(@RequestBody CommentCreateCommand create, @Login User user) {
        commentService.create(create, user);
    }

    @Operation(summary = "删除评论")
    @DeleteMapping
    public void delete(@RequestBody CommentDeleteCommand delete, @Login User user) {
        commentService.delete(delete, user);
    }

    @Operation(summary = "分页查询评论")
    @GetMapping("/page")
    public Pages<CommentVO> page(CommentQuery query, Pages.Args page) {
        return commentSearcher.page(query, page);
    }
}
