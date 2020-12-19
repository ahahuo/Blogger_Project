package cn.wd.model;

import java.util.Date;

public class Article {
    private int article_id;
    private int user_id;
    private String article_title;
    private String article_content;
    private int article_views;
    private int article_comment_count;
    private Date article_date;
    private int article_like_count;
    private boolean is_delete;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public int getArticle_views() {
        return article_views;
    }

    public void setArticle_views(int article_views) {
        this.article_views = article_views;
    }

    public int getArticle_comment_count() {
        return article_comment_count;
    }

    public void setArticle_comment_count(int article_comment_count) {
        this.article_comment_count = article_comment_count;
    }

    public Date getArticle_date() {
        return article_date;
    }

    public void setArticle_date(Date article_date) {
        this.article_date = article_date;
    }

    public int getArticle_like_count() {
        return article_like_count;
    }

    public void setArticle_like_count(int article_like_count) {
        this.article_like_count = article_like_count;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }
}
