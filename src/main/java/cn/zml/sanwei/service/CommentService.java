package cn.zml.sanwei.service;

import cn.zml.sanwei.config.SanweiException;

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
}
