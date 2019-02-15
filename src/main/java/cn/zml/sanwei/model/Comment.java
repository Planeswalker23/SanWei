package cn.zml.sanwei.model;

import java.util.UUID;

/**
 * @author  fanyidong
 * @date Created in 2018/11/29
 */
public class Comment {

    private String commentId;
    private String bookId;
    private String person;
    private String commentContent;
    private String commentDate;
    private String comentGrade;

    public Comment() {
    }

    public Comment(String bookId, String person, String commentContent, String commentDate, String comentGrade) {
        this.setCommentId(UUID.randomUUID().toString());
        this.setBookId(bookId);
        this.person = person;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.comentGrade = comentGrade;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

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

    public String getComentGrade() {
        return comentGrade;
    }

    public void setComentGrade(String comentGrade) {
        this.comentGrade = comentGrade;
    }
}
