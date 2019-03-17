package cn.zml.sanwei.controller;

import cn.zml.sanwei.config.SanWeiRes;
import cn.zml.sanwei.model.User;
import cn.zml.sanwei.service.UserService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.zml.sanwei.config.Constant.USER_BEAN;

/**
 * User控制层
 * @author fanyidong
 * @date Created in 2018-12-11
 */
@RestController
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param account 账户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes login(String account, String password, HttpServletRequest request) throws Exception {
        // 验证参数是否为空
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return SanWeiRes.noParam();
        }
        User userBean = userService.login(account, password);
        // 将用户信息存入session
        HttpSession session = request.getSession();
        session.setAttribute(USER_BEAN, userBean);
        log.info("【登录成功】" + USER_BEAN + "sessionId ==> " + session.getId() + " ==> " + JSON.toJSONString(userBean));
        // 将用户密码置空
        userBean.setPassword(null);
        return SanWeiRes.success(userBean);
    }

    /**
     * 查询用户个人信息
     * @param userId 用户id
     * @return
     * @throws Exception
     */
    @PostMapping("/userInfo")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes info(String userId) throws Exception {
        // 验证参数是否为空
        if (StringUtils.isEmpty(userId)) {
            return SanWeiRes.noParam("用户id");
        }
        return SanWeiRes.success(userService.getUserInfo(userId));

    }


    /**
     * 注册 or 修改个人信息
     * @param newUser (注册){"account":"dd","password":"1","email":"123@qq.com","mobile":"10086"}
     *               (修改个人信息){"userId":"bf6eb812-4b38-4965-a121-bf297d58447c","account":"dd","password":"1","email":"123@qq.com","mobile":"10086"}
     * @return
     * @throws Exception
     */
    @PostMapping("/apply")
    @Transactional(rollbackFor = Exception.class)
    public SanWeiRes apply(User newUser) throws Exception {
        userService.applyUser(newUser);
        return SanWeiRes.success();
    }
}
