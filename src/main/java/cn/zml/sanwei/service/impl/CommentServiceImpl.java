package cn.zml.sanwei.service.impl;

import cn.zml.sanwei.dao.CommentDao;
import cn.zml.sanwei.dao.UserDao;
import cn.zml.sanwei.model.Comment;
import cn.zml.sanwei.model.User;
import cn.zml.sanwei.service.CommentService;
import cn.zml.sanwei.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static cn.zml.sanwei.config.Constant.YEAR_MONTH_DAY_HOUR_MUNITE_SECOND;

/**
 * @author fanyidong
 * @date Created in 2019-03-24
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    @Override
    public void applyComment(String userId, String bookId, double grade, String commentContent) {
        // insert还是update
        boolean isInsert = false;
        // 根据userId查询用户信息
        User user = userDao.queryByUserId(userId);
        // 根据bookId和account(person字段)查看该用户有没有对本书做出过评分
        Comment comment = commentDao.getCommentByBookIdPerson(bookId, user.getAccount());
        // 如果没有评论过，则是插入
        if (comment == null) {
            isInsert = true;
            comment = new Comment();
            comment.setBookId(bookId);
            comment.setPerson(user.getAccount());
        }
        comment.setComentGrade(grade);
        comment.setCommentContent(commentContent);
        comment.setCommentDate(DateUtils.dateToString(new Date(), YEAR_MONTH_DAY_HOUR_MUNITE_SECOND));
        if (isInsert) {
            commentDao.insert(comment);
        } else {
            commentDao.updateByCommentId(comment);
        }
    }
}
