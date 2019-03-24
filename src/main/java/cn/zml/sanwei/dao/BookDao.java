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
     * 根据id查找book所有信息
     * @param bookId
     * @return BookDetailComments
     */
    Book getBookById(@Param("bookId") String bookId);

    /**
     * 根据书名、作者、类别查询是否有重复数据
     * @param book name、writer、type
     * @return Book对象
     */
    Book queryBookByNameWriter(Book book);

    /**
     * 查询评分前十的图书
     * 排序规则：评分>评论人数>出版日期 desc
     * @return
     */
    List<Book> getGradeTop10();

    /**
     * 根据类型查询book
     * @param type 类型
     * @return
     */
    List<Book> getBooksByType(@Param("type") Integer type);

    /**
     * 查询分数大于8的书籍
     * @return
     */
    List<Book> getBooksWhichGradeOver8();

    /**
     * 随机查询几条数据
     * @return
     */
    List<Book> getBooksOrderByPeople();

    /**
     * 根据出版日期降序取前num本
     * @param num 需要多少本
     * @return
     */
    List<Book> getBooksOrderByDate(@Param("num") Integer num);

    /**
     * 更新书本评分及人数
     * @param book
     * @return
     */
    int updateBookGradePeopleByBookId(Book book);
}
