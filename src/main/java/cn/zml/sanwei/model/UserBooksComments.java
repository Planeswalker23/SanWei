package cn.zml.sanwei.model;

/**
 * 用户评论书籍及评论内容实体类
 * @author fanyidong
 * @date Created in 2019-03-24
 */
public class UserBooksComments extends Book {

    private String commentContent;
    private String commentDate;
    private String commentGrade;

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentGrade() {
        return commentGrade;
    }

    public void setCommentGrade(String commentGrade) {
        this.commentGrade = commentGrade;
    }
}
