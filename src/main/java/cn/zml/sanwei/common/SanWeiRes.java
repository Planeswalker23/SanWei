package cn.zml.sanwei.common;

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

    public static <T> SanWeiRes success(T data) {
        SanWeiRes<T> sw = new SanWeiRes<>();
        sw.setCode(200);
        sw.setRes(data);
        return sw;
    }

    public static SanWeiRes failed(String reason) {
        SanWeiRes sw = new SanWeiRes();
        sw.setCode(500);
        sw.setReason(reason);
        return sw;
    }
}
