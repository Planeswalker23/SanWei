package cn.zml.sanwei.dao;

import cn.zml.sanwei.model.Book;
import cn.zml.sanwei.model.BookDto;
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
     * 批量插入数据
     * @param books
     * @return
     */
    int insertList(List<Book> books);

    /**
     * 查询所有图书信息
     * @return list
     */
    List<BookDto> queryAllBooks();

    /**
     * 根据id查找book
     * @param bookId
     * @return int
     */
    int countBookById(@Param("bookId") String bookId);

    /**
     * 根据书名、作者、类别查询数据
     * 书名和作者支持模糊搜索
     * @param book
     * @return Book对象
     */
    Book queryBook(Book book);
}
