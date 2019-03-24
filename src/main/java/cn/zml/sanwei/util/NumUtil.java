package cn.zml.sanwei.util;

import java.math.BigDecimal;

/**
 * 数值转换工具类
 * @author fanyidong
 * @date Created in 2019-02-19
 */
public class NumUtil {

    /**
     * 四舍五入格式化数字
     * @param newScale 需要保留的小数位
     * @param value 数值
     * @return string string类型的结果
     */
    public static String stateScale(int newScale, Object value) {
        BigDecimal bigDecimal = new BigDecimal(value.toString());
        bigDecimal = bigDecimal.setScale(newScale, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString();
    }
}
