package cn.zml.sanwei.service.impl;

import cn.zml.sanwei.dao.BookDao;
import cn.zml.sanwei.dao.CommentDao;
import cn.zml.sanwei.dao.DetailDao;
import cn.zml.sanwei.model.Book;
import cn.zml.sanwei.model.BookDto;
import cn.zml.sanwei.model.Comment;
import cn.zml.sanwei.service.BookService;
import cn.zml.sanwei.util.HttpClientUtil;
import cn.zml.sanwei.util.ReadFileUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    DetailDao detailDao;
    @Autowired
    CommentDao commentDao;

    @Override
    public List<BookDto> queryAllBooks() {
        // 查询图书
        List<BookDto> resList = bookDao.queryAllBooks();
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
    public String insertList(String filePath) {
        String content = ReadFileUtil.readFileByLines(filePath);
        List<Book> books = JSON.parseArray(content, Book.class);
        for (int i = 0; i < books.size(); i++) {
            //book表主键no
            String uuid = UUID.randomUUID().toString();
            books.get(i).setBookId(uuid);
        }
        //插入book表
        bookDao.insertList(books);
        return "success";
    }

    @Override
    public String insertDtailAndComment() throws IOException {
        List<BookDto> books = bookDao.queryAllBooks();
        List<String> failList = new ArrayList<>();
        for (BookDto book : books) {
            book = HttpClientUtil.getDetailAndComments(book);
            int hasBook = bookDao.countBookById(book.getBookId());
            if (hasBook == 0) {
                failList.add(book.getBookId());
                System.out.println("已存在 ----- " + book.getName() + " ID=" + book.getBookId());
            }
            try {
                //插入detail表
                detailDao.insertList(book.getDetail());
                //插入comment表
                if (book.getComments().size() != 0) {
                    commentDao.insertList(book.getComments());
                }
            } catch (SQLException e) {
                System.out.println("数据错误 ----- " + book.getName() + " - ID=" + book.getBookId());
            }
            System.out.println("插入成功 ----- " + book.getName());
        }
        return failList.toString();
    }
}
