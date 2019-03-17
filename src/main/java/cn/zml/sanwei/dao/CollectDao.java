package cn.zml.sanwei.dao;

import cn.zml.sanwei.model.Collect;
import cn.zml.sanwei.model.CollectBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * collectDao
 * @author fanyidong
 * @date Created in 2019-03-17
 */
@Repository
public interface CollectDao {

    /**
     * 插入单条记录(id,userid,bookid,collecttime)
     * @param collect
     */
    void insert(Collect collect);

    /**
     * 根据userid,bookid删除记录
     * @param collect
     */
    void delete(Collect collect);

    /**
     * 根据userId联合查询book表和collect表
     * @param userId
     * @return
     */
    List<CollectBook> getCollectionsFromBookAndCollectByUserId(@Param("userId") String userId);

    /**
     * 检查用户是否收藏过本书
     * @param userId
     * @param bookId
     * @return
     */
    int hasBookCollected(@Param("userId") String userId, @Param("bookId") String bookId);
}
