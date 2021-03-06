package cn.zml.sanwei.service.impl;

import cn.zml.sanwei.config.SanweiException;
import cn.zml.sanwei.dao.BookDao;
import cn.zml.sanwei.dao.CommentDao;
import cn.zml.sanwei.dao.UserDao;
import cn.zml.sanwei.model.Book;
import cn.zml.sanwei.model.Comment;
import cn.zml.sanwei.model.User;
import cn.zml.sanwei.model.UserBooksComments;
import cn.zml.sanwei.service.CommentService;
import cn.zml.sanwei.util.DateUtils;
import cn.zml.sanwei.util.NumUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static cn.zml.sanwei.config.Constant.*;

/**
 * @author fanyidong
 * @date Created in 2019-03-24
 */
@Service
public class CommentServiceImpl implements CommentService {

    private static Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public void applyComment(String userId, String bookId, Double grade, String commentContent) throws SanweiException {
        // insert还是update
        boolean isInsert = false;
        // 根据userId查询用户信息
        User user = userDao.queryByUserId(userId);
        if (user == null) {
            throw new SanweiException(USER_NOT_EXIST);
        }
        Book book = bookDao.getBookById(bookId);
        if (book == null) {
            throw new SanweiException(DATA_ERROR_NO_SUCH_BOOK);
        }
        // 根据bookId和account(person字段)查看该用户有没有对本书做出过评分
        Comment comment = commentDao.getCommentByBookIdPerson(bookId, user.getAccount());
        // 如果没有评论过，则是插入
        if (comment == null) {
            isInsert = true;
            comment = new Comment();
            comment.setBookId(bookId);
            comment.setPerson(user.getAccount());
        } else {
            log.info("原来的评论内容为 ==> " + JSON.toJSONString(comment));
        }
        // 更新书本总评分
        if (grade != null) {
            // 更新本书总评分
            updateOldGrade(book, grade);
            // 设置本次评价分数
            comment.setCommentGrade(String.valueOf(grade));
        }
        comment.setCommentContent(commentContent);
        comment.setCommentDate(DateUtils.dateToString(new Date(), YEAR_MONTH_DAY_HOUR_MUNITE_SECOND));
        if (isInsert) {
            commentDao.insert(comment);
            log.info("插入新的评论，插入的内容为 ==> " + JSON.toJSONString(comment));
        } else {
            commentDao.updateByCommentId(comment);
            log.info("更新评论，更新后的内容为 ==> " + JSON.toJSONString(comment));
        }
    }

    @Override
    public PageInfo<UserBooksComments> getUserComments(String userId, Integer pageNum, Integer pageSize) throws SanweiException {
        PageHelper.startPage(pageNum, pageSize);
        User user = userDao.queryByUserId(userId);
        if (user == null) {
            throw new SanweiException(USER_NOT_EXIST);
        }
        return new PageInfo<>(commentDao.getPersonalCommentsByPersonName(user.getAccount()));
    }

    private void updateOldGrade(Book book, Double grade) {
        // 不更新评分
        if (grade == null) {
            return;
        }
        double perGrade = Double.valueOf(book.getGrade());
        int people = Integer.valueOf(book.getPeople());
        log.info("本书【" + book.getName() + "】原来的评分是 ==> " + perGrade + " 评价人数是 ==> " + people);
        log.info("除数=" + (perGrade * people + grade) + "；除数=" + (people+1));
        perGrade = (perGrade * people + grade) / (people+1);
        log.info("计算之后的评分 == > " + perGrade);
        String newGrade = NumUtil.stateScale(1, perGrade);
        // 更新book
        book.setGrade(newGrade);
        book.setPeople(String.valueOf(people));
        bookDao.updateBookGradePeopleByBookId(book);
        log.info("本书【" + book.getName() + "】现在的评分是 ==> " + newGrade + " 评价人数是 ==> " + people+1);
    }
}
