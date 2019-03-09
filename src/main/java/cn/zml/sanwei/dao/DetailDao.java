package cn.zml.sanwei.dao;

import cn.zml.sanwei.model.Detail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@Repository
public interface DetailDao {

    /**
     * 批量插入数据
     * @param details
     * @throws SQLException
     * @return int
     */
    int insertList(Detail details) throws SQLException;

    /**
     * 根据bookId获取图书详情
     * @param bookId
     * @return Detail
     */
    Detail getDetailById(@Param("bookId") String bookId);
}
