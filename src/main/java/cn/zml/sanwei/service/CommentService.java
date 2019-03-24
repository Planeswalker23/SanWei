package cn.zml.sanwei.service;

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
     */
    void applyComment(String userId, String bookId, double grade, String commentContent);
}
