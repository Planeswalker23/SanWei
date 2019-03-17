package cn.zml.sanwei.service;

import cn.zml.sanwei.config.SanweiException;
import cn.zml.sanwei.model.CollectBook;

import java.util.List;

/**
 * collect服务层
 * @author fanyidong
 * @date Created in 2019-03-17
 */
public interface CollectService {

    /**
     * 插入单条记录(id,userid,bookid,collecttime)
     * @param userId
     * @param bookId
     * @throws SanweiException
     */
    void insert(String userId, String bookId) throws SanweiException;

    /**
     * 根据userid,bookid删除记录
     * @param userId
     * @param bookId
     */
    void delete(String userId, String bookId);

    /**
     * 根据userId联合查询book表和collect表
     * @param userId
     * @return
     */
    List<CollectBook> getCollectionsFromBookAndCollectByUserId(String userId);
}
