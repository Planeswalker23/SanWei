package cn.zml.sanwei.util;

import cn.zml.sanwei.config.SanWeiRes;
import cn.zml.sanwei.model.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static cn.zml.sanwei.config.Constant.USER_BEAN;

/**
 * 验证工具类
 * @author fanyidong
 * @date Created in 2018-12-14
 */
public class CheckUtils {

    /**
     * 验证邮箱格式
     * @param email
     * @return ture 正确 false 不正确
     */
    public static boolean checkEmail(String email) {
        String rule = "^[A-Za-zd0-9]+([-_.][A-Za-zd0-9]+)*@([A-Za-zd0-9]+[-.])+[A-Za-zd]{2,5}$";
        Pattern p = Pattern.compile(rule);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断时间是否过期
     * @param lastMailOutTime 过期时间
     * @return ture-安全码已过期 false-安全码未过期
     */
    public static boolean isEmailOutTime(Date lastMailOutTime) {
        // 若安全码已过期，返回true
        return lastMailOutTime.before(new Date());
    }

    /**
     * 判断参数是否缺少的公用方法
     * @param bookId 查看参数是否缺失
     * @param request
     * @return userId
     */
    public static Object checkParamLogin(String bookId, HttpServletRequest request) {
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
}
