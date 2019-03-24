package cn.zml.sanwei.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转换工具类
 * @author fanyidong
 * @date Created in 2018-12-14
 */
public class DateUtils {

    /**
     * Date类型转换为String类型
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * String类型转化为date
     *
     * @param time
     * @param format
     * @return
     */
    public static Date stringToDate(String time, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(time);
    }
}
