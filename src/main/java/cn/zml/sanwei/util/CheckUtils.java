package cn.zml.sanwei.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
