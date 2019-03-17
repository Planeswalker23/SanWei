package cn.zml.sanwei.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import static cn.zml.sanwei.config.Constant.*;

/**
 * 公用返回类
 * @Author fanyidong
 * @Despriction
 * @Date:Created in 2018-12-08
 */
public class SanWeiRes<T> {

    /**
     * 返回状态码 200-成功 500-错误
     */
    private Integer code;

    /**
     * 如果失败，则返回错误内容
     */
    private String reason;

    /**
     * 请求返回内容
     */
    private T res;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    public static SanWeiRes success() {
        SanWeiRes sw = new SanWeiRes();
        sw.setCode(REQUEST_SUCCESS_CODE);
        sw.setReason("成功");
        return sw;
    }

    public static <T> SanWeiRes success(T data) {
        SanWeiRes<T> sw = new SanWeiRes<>();
        sw.setCode(REQUEST_SUCCESS_CODE);
        sw.setRes(data);
        return sw;
    }

    public static SanWeiRes failed(String reason) {
        SanWeiRes sw = new SanWeiRes();
        sw.setCode(REQUEST_FAILED_CODE);
        sw.setReason(reason);
        return sw;
    }

    public static SanWeiRes noParam(String param) {
        SanWeiRes sw = new SanWeiRes();
        sw.setCode(REQUEST_FAILED_CODE);
        sw.setReason("缺少参数【" + param + "】");
        return sw;
    }

    public static SanWeiRes noParam() {
        SanWeiRes sw = new SanWeiRes();
        sw.setCode(REQUEST_FAILED_CODE);
        sw.setReason(EMPTY_PARAMS);
        return sw;
    }

    public static SanWeiRes notLogin() {
        SanWeiRes sw = new SanWeiRes();
        sw.setCode(REQUEST_FAILED_CODE);
        sw.setReason(NOT_LOGIN);
        return sw;
    }

    @Override
    public String toString() {
        //返回json时只返回不为null的字段
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
