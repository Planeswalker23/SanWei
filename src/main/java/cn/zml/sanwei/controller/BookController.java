package cn.zml.sanwei.controller;

import cn.zml.sanwei.common.SanWeiRes;
import cn.zml.sanwei.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书控制层
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/getBooks")
    public SanWeiRes getBoos() {
        try {
            return SanWeiRes.success(bookService.queryAllBooks());
        } catch (Exception e) {
            e.printStackTrace();
            return SanWeiRes.failed("系统错误，请联系管理员");
        }
    }

    @PostMapping("/insertBooks")
    @Transactional(rollbackFor = Exception.class)
    public String insertList(String filePath) {
        return bookService.insertList(filePath);
    }

    @GetMapping("/insertOthers")
    @Transactional(rollbackFor = Exception.class)
    public String insertOthers() {
        try {
            return bookService.insertDtailAndComment();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "success";
    }
}
