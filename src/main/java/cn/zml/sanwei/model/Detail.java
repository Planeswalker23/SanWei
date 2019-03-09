package cn.zml.sanwei.model;

import com.alibaba.fastjson.annotation.JSONField;

import static cn.zml.sanwei.common.Constant.THOUSAND;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
public class Detail {

    private String detailId;
    private String bookId;
    private String writer;
    private String content;
    private String catalog;

    private String createTime;
    private String updateTime;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        // 防止属性太长超出数据库的设定值
        if (writer != null && writer.length() > THOUSAND) {
            this.writer = writer.substring(0, 990);
        } else {
            this.writer = writer;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content.length() > THOUSAND) {
            this.content = content.substring(0, 990);
        } else {
            this.content = content;
        }
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        if (catalog.length() > THOUSAND) {
            this.catalog = catalog.substring(0, 990);
        } else {
            this.catalog = catalog;
        }
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
