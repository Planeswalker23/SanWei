package cn.zml.sanwei.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 查询收藏书籍的实体类
 * @author fanyidong
 * @date Created in 2019-03-17
 */
public class CollectBook extends Book {


    private Integer id;
    private String userId;

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

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
}
