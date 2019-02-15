package cn.zml.sanwei.dao;

import cn.zml.sanwei.model.Comment;
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
     * 查询所有书评
     * @return list
     */
    List<Comment> getComments();
}
