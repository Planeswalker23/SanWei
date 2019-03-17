package cn.zml.sanwei.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
public class BookDetailComments extends Book {

    private Detail detail;
    private List<Comment> comments;

    /**
     * 如果用户已登录，返回是否被当前用户收藏字段，默认未收藏
     */
    private boolean hadCollected = false;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Comment> getComments() {
        if (comments == null) {
            comments = new ArrayList<>();
            return comments;
        }
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isHadCollected() {
        return hadCollected;
    }

    public void setHadCollected(boolean hadCollected) {
        this.hadCollected = hadCollected;
    }
}
