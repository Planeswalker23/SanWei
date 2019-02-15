package cn.zml.sanwei.model;

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
        if (writer != null && writer.length() > 1000) {
            this.writer = writer.substring(0, 990);
        } else {
            this.writer = writer;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content.length() > 1000) {
            this.content = content.substring(0, 990);
        } else {
            this.content = content;
        }
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        if (catalog.length() > 1000) {
            this.catalog = catalog.substring(0, 990);
        } else {
            this.catalog = catalog;
        }
    }
}
