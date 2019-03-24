package cn.zml.sanwei.dao;

import cn.zml.sanwei.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@Repository
public interface CommentDao {

    /**
     * 批量插入数据
     * @param comments
     * @throws SQLException
     * @return int
     */
    int insertList(List<Comment> comments) throws SQLException;

    /**
     * 根据bookId查询所有书评
     * @param bookId
     * @return list
     */
    List<Comment> getCommentsByBookId(@Param("bookId") String bookId);

    /**
     * 根据bookId和account(person字段)查看该用户有没有对本书做出过评分
     * @param bookId
     * @param account
     * @return
     */
    Comment getCommentByBookIdPerson(@Param("bookId") String bookId, @Param("person") String account);

    /**
     * 插入单个评论对象
     * @param comment
     * @return
     */
    int insert(Comment comment);

    /**
     * 根据主键更新评分，评论内容，评论日期三个字段
     * @param comment
     * @return
     */
    int updateByCommentId(Comment comment);
}
