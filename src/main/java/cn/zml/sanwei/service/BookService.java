package cn.zml.sanwei.service;

import cn.zml.sanwei.model.Book;
import cn.zml.sanwei.model.BookDetailComments;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@Service
public interface BookService {

    /**
     * 根据id查询书籍及所有评论信息
     * @param bookId
     * @return BookDetailComments
     */
    BookDetailComments getBookById(String bookId);

    /**
     * 批量插入
     * @param filePath
     * @return
     */
    void insertBooks(String filePath);

    /**
     * 根据book表数据插入另外两张表
     * @return
     */
    String insertDetailAndComment();

    /**
     * 查询评分前十的图书
     * 排序规则：评分>评论人数>出版日期 desc
     * @return
     */
    List<Book> getGradeTop10();

    /**
     * 根据类型查询书籍
     * @param type 类型
     * @param pageNum 页码
     * @param pageSize 每页数目
     * @return BookDetailComments
     */
    PageInfo<Book> getBookByType(Integer type, Integer pageNum, Integer pageSize);

    /**
     * 下载所有书籍的封面
     * @throws Exception
     */
    void downloadImg() throws Exception;
}
