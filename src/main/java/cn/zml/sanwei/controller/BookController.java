package cn.zml.sanwei.controller;

import cn.zml.sanwei.config.SanWeiRes;
import cn.zml.sanwei.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.zml.sanwei.config.Constant.SYSTEM_ERROR;

/**
 * 图书控制层
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@RestController
public class BookController {

    private static Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @PostMapping("/insertBooks")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes insertBooks(String filePath) {
        try {
            bookService.insertBooks(filePath);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return SanWeiRes.failed(SYSTEM_ERROR);
        }
        return SanWeiRes.success();
    }

    @GetMapping("/insertOthers")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes insertOthers() {
        try {
            return SanWeiRes.success(bookService.insertDetailAndComment());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return SanWeiRes.failed(SYSTEM_ERROR);
        }
    }

    @GetMapping("downloadImg")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes downloadImgController() {
        try {
            bookService.downloadImg();
            return SanWeiRes.success();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return SanWeiRes.failed(e.getCause().toString());
        }
    }

    @PostMapping("/getBookById")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes getBookByIdController(String bookId, String userId) {
        try {
            return SanWeiRes.success(bookService.getBookById(bookId, userId));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return SanWeiRes.failed(SYSTEM_ERROR);
        }
    }

    @PostMapping("getGradeTop10")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes getGradeTop10Controller() {
        return SanWeiRes.success(bookService.getGradeTop10());
    }

    @PostMapping("getBooksByType")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes getBooksByTypeController(Integer type, Integer pageNum, Integer pageSize) {
        return SanWeiRes.success(bookService.getBookByType(type, pageNum,pageSize));
    }

    @PostMapping("getBooksOrderByDate")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes getBooksOrderByDateController(Integer num) {
        return SanWeiRes.success(bookService.getBooksOrderByDate(num));
    }

    @PostMapping("search")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes search(String keyword, Integer pageNum, Integer pageSize) {
        if (StringUtils.isEmpty(keyword)) {
            return SanWeiRes.noParam("关键词");
        }
        return SanWeiRes.success(bookService.search(keyword, pageNum, pageSize));
    }
}
