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
}
