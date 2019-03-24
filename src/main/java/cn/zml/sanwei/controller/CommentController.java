package cn.zml.sanwei.controller;

import cn.zml.sanwei.config.SanWeiRes;
import cn.zml.sanwei.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论相关controller
 * @author fanyidong
 * @date Created in 2019-03-24
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("applyComment")
    public SanWeiRes applyComment(String userId, String bookId, double grade, String commentContent) throws Exception {
        commentService.applyComment(userId, bookId, grade, commentContent);
        return SanWeiRes.success();
    }
}
