package cn.zml.sanwei.service;

import cn.zml.sanwei.config.SanweiException;
import cn.zml.sanwei.model.UserBooksComments;
import com.github.pagehelper.PageInfo;

/**
 * @author fanyidong
 * @date Created in 2019-03-24
 */
public interface CommentService {

    /**
     * 增加/更新评论
     * @param userId
     * @param bookId
     * @param grade
     * @param commentContent
     * @throws SanweiException
     */
    void applyComment(String userId, String bookId, Double grade, String commentContent) throws SanweiException;

    /**
     * 根据用户名查询他所评论的书籍
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SanweiException
     */
    PageInfo<UserBooksComments> getUserComments(String userId, Integer pageNum, Integer pageSize) throws SanweiException;
}
