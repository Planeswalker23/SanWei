package cn.zml.sanwei.service;

import cn.zml.sanwei.model.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@Service
public interface BookService {

    /**
     * 查询所有书籍及评论
     * @return
     */
    List<BookDto> queryAllBooks();

    /**
     * 批量插入
     * @param filePath
     * @return
     */
    String insertList(String filePath);

    /**
     * 根据book表数据插入另外两张表
     * @return
     * @throws Exception
     */
    String insertDtailAndComment() throws Exception;
}
