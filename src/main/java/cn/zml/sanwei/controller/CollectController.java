package cn.zml.sanwei.controller;

import cn.zml.sanwei.config.SanWeiRes;
import cn.zml.sanwei.config.SanweiException;
import cn.zml.sanwei.model.User;
import cn.zml.sanwei.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.zml.sanwei.config.Constant.SUCCESS;
import static cn.zml.sanwei.config.Constant.USER_BEAN;

/**
 * 收藏功能控制层
 * @author fanyidong
 * @date Created in 2019-03-17
 */
@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 判断参数是否缺少的公用方法
     * @param request
     * @return userId
     */
    private Object checkParamLogin(String bookId, HttpServletRequest request) {
        // 验证参数是否缺失
        if (StringUtils.isEmpty(bookId)) {
            return SanWeiRes.noParam("书籍id");
        }
        // 获得session
        HttpSession session = request.getSession();
        if (session == null) {
            return SanWeiRes.notLogin();
        }
        // 获得session中的user对象
        User userBean = (User) session.getAttribute(USER_BEAN);
        if (userBean == null) {
            return SanWeiRes.notLogin();
        }
        return userBean.getUserId();
    }

    @PostMapping("addCollect")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes addCollect(String bookId, HttpServletRequest request) throws SanweiException {
        // 验证是否登录，如果返回SanWeiRes类则出错
        Object o = checkParamLogin(bookId, request);
        if (o instanceof SanWeiRes) {
            return (SanWeiRes) o;
        }
        // 转换成userId
        String userId = (String) o;
        collectService.insert(userId, bookId);
        return SanWeiRes.success();
    }

    @PostMapping("deleteCollect")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes deleteCollect(String bookId, HttpServletRequest request) {
        // 验证是否登录，如果返回SanWeiRes类则出错
        Object o = checkParamLogin(bookId, request);
        if (o instanceof SanWeiRes) {
            return (SanWeiRes) o;
        }
        // 转换成userId
        String userId = (String) o;
        collectService.delete(userId, bookId);
        return SanWeiRes.success();
    }

    @PostMapping("getCollections")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes getCollections(HttpServletRequest request) {
        // 验证是否登录，如果返回SanWeiRes类则出错
        Object o = checkParamLogin(SUCCESS, request);
        if (o instanceof SanWeiRes) {
            return (SanWeiRes) o;
        }
        // 转换成userId
        String userId = (String) o;
        return SanWeiRes.success(collectService.getCollectionsFromBookAndCollectByUserId(userId));
    }
}
