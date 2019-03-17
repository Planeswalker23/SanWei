package cn.zml.sanwei.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author fanyidong
 * @date Created in 2019-03-17
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Collect {

    private Integer id;
    private String userId;
    private String bookId;
    private String collectTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
}
