package cn.wd.model;

import java.util.Date;

public class Comment {
    private int comment_id;
    private int user_id;
    private int article_id;
    private int comment_like_count;
    private Date comment_date;
    private String comment_content;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getComment_like_count() {
        return comment_like_count;
    }

    public void setComment_like_count(int comment_like_count) {
        this.comment_like_count = comment_like_count;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
}
