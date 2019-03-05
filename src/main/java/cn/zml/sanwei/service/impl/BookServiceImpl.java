package cn.zml.sanwei.service.impl;

import cn.zml.sanwei.dao.BookDao;
import cn.zml.sanwei.dao.CommentDao;
import cn.zml.sanwei.dao.DetailDao;
import cn.zml.sanwei.model.Book;
import cn.zml.sanwei.model.BookDetailComments;
import cn.zml.sanwei.model.Comment;
import cn.zml.sanwei.service.BookService;
import cn.zml.sanwei.util.HttpClientUtil;
import cn.zml.sanwei.util.ReadFileUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<BookDetailComments> queryAnyBooks() {
        // 查询图书
        List<BookDetailComments> resList = bookDao.queryAnyBooks();
        // 查询评论
        List<Comment> comments = commentDao.getComments();
        // 将评论与图书对应
        for (int i=0; i<comments.size();i++) {
            Comment commentDto = comments.get(i);
            for (int j = 0; j < resList.size(); j++) {
                if (commentDto.getBookId().equals(resList.get(j).getBookId())) {
                    resList.get(j).getComments().add(commentDto);
                    continue;
                }
            }
        }
        return resList;
    }

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
    public String insertDtailAndComment() {
        // 获取所有书籍的信息
        List<BookDetailComments> books = bookDao.queryAnyBooks();
        // 插入失败的图书信息
        List<String> failList = new ArrayList<>();
        for (BookDetailComments book : books) {
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
}
