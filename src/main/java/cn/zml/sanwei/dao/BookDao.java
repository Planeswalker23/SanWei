package cn.zml.sanwei.dao;

import cn.zml.sanwei.model.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@Repository
public interface BookDao {

    /**
     * 插入数据
     * @param books book列表
     * @return
     */
    int insertAnyFieldsByList(List<Book> books);

    /**
     * 查询所有图书信息
     * @return list
     */
    List<Book> queryAnyBooks();

    /**
     * 根据id查找book
     * @param bookId
     * @return int
     */
    int countBookById(@Param("bookId") String bookId);

    /**
     * 根据书名、作者、类别查询是否有重复数据
     * @param book name、writer、type
     * @return Book对象
     */
    Book queryBookByNameWriter(Book book);
}
