package cn.zml.sanwei.service.impl;

import cn.zml.sanwei.dao.BookDao;
import cn.zml.sanwei.dao.CommentDao;
import cn.zml.sanwei.dao.DetailDao;
import cn.zml.sanwei.model.Book;
import cn.zml.sanwei.model.BookDetailComments;
import cn.zml.sanwei.model.Comment;
import cn.zml.sanwei.model.Detail;
import cn.zml.sanwei.service.BookService;
import cn.zml.sanwei.util.HttpClientUtil;
import cn.zml.sanwei.util.ReadFileUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static cn.zml.sanwei.common.Constant.*;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@Service
public class BookServiceImpl implements BookService {

    private static Logger log = LoggerFactory.getLogger(BookServiceImpl.class);


    @Autowired
    BookDao bookDao;
    @Autowired
    DetailDao detailDao;
    @Autowired
    CommentDao commentDao;

    @Override
    public void insertBooks(String filePath) {
        String content = ReadFileUtil.readFileByLines(filePath);
        List<Book> books = JSON.parseArray(content, Book.class);
        List<Book> insertBooks = new ArrayList<>();
        for (Book book:books) {
            // 查询表中是否存在该书籍
            if (bookDao.queryBookByNameWriter(book)!=null) {
                log.info("【已存在】 ----- " + book.getName() + " id=" + book.getBookId());
                continue;
            }
            insertBooks.add(book);
            log.info("【加入待插入列表成功】 ----- " + book.getName());
        }
        //批量插入book表
        bookDao.insertAnyFieldsByList(insertBooks);
        log.info("【插入图书成功】共插入" + insertBooks.size() + "本图书");
    }

    @Override
    public String insertDetailAndComment() {
        // 获取所有书籍的信息
        List<Book> books = bookDao.queryAnyBooks();
        // list对象转换
        List<BookDetailComments> bookDetailComments = JSON.parseArray(JSON.toJSONString(books), BookDetailComments.class);
        // 插入失败的图书信息
        List<String> failList = new ArrayList<>();
        for (BookDetailComments book : bookDetailComments) {
            try {
                // 获取书籍详情及评论
                book = HttpClientUtil.getDetailAndComments(book);
            } catch (IOException e) {
                log.error("【http请求异常】 ----- " + book.getName() + " ID=" + book.getBookId(), e);
            }
            // 查询该图书是否存在
            int hasBook = bookDao.countBookById(book.getBookId());
            if (hasBook == 0) {
                log.info("【图书不存在】 ----- " + book.getName() + " ID=" + book.getBookId());
                continue;
            }
            try {
                //插入detail表
                detailDao.insertList(book.getDetail());
                //插入comment表
                if (book.getComments().size() != 0) {
                    commentDao.insertList(book.getComments());
                }
            } catch (SQLException e) {
                failList.add(book.getBookId());
                log.error("【插入失败】 ----- " + book.getName() + " - ID=" + book.getBookId(), e);
            }
            log.info("【插入成功】 ----- " + book.getName());
        }
        // 返回失败的数据
        return JSON.toJSONString(failList);
    }

    @Override
    public void downloadImg() throws Exception {
        List<Book> books = bookDao.queryAnyBooks();
        for (Book book:books) {
            String url = book.getImg();
            String no = book.getNo();
            HttpClientUtil.downloadImg(url, "logs/img/" + no+".png");
            log.info(book.getName() + "封面下载完成");
        }
    }

    @Override
    public BookDetailComments getBookById(String bookId) {
        // 获取book所有信息
        Book book = bookDao.getAllBookContentById(bookId);
        // 获取图书详情
        Detail detail = detailDao.getDetailById(bookId);
        // 获取书评
        List<Comment> comments = commentDao.getCommentsByBookId(bookId);
        // 返回的图书所有信息
        BookDetailComments allBookContent = new BookDetailComments();
        BeanUtils.copyProperties(book, allBookContent);
        allBookContent.setDetail(detail);
        allBookContent.setComments(comments);
        return allBookContent;
    }

    @Override
    public List<Book> getGradeTop10() {
        return bookDao.getGradeTop10();
    }

    @Override
    public PageInfo<Book> getBookByType(Integer type, Integer pageNum, Integer pageSize) {
        // 设置分页信息
        PageHelper.startPage(pageNum, pageSize);
        // 查询结果
        List<Book> list;
        if (type.equals(RANDOM_BOOK)) {
            // 11-特色书籍
            list = bookDao.getBooksOrderByPeople();
        } else if (type.equals(GOOD_BOOK)) {
            // 12-好书推荐
            list = bookDao.getBooksWhichGradeOver8();
        } else {
            // 类别1-10
            list = bookDao.getBooksByType(type);
        }
        return new PageInfo<>(list);
    }

    @Override
    public List<Book> getBooksOrderByDate() {
        return bookDao.getBooksOrderByDate();
    }
}
