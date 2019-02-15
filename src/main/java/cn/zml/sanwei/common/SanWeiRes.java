package cn.zml.sanwei.common;

/**
 * @Author fanyidong
 * @Despriction
 * @Date:Created in 2018-12-08
 */
public class SanWeiRes {

    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static SanWeiRes success(Object data) {
        SanWeiRes bs = new SanWeiRes();
        bs.setCode(200);
        bs.setData(data);
        return bs;
    }

    public static SanWeiRes failed(String reason) {
        SanWeiRes bs = new SanWeiRes();
        bs.setCode(500);
        bs.setMessage(reason);
        return bs;
    }
}
