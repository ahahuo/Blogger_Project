package cn.wd.model;

public class Sort {
    private int sort_id;
    private String sort_name;
    private String sort_description;
    private boolean is_delete;
    private int sort_articles_count;

    public int getSort_id() {
        return sort_id;
    }

    public void setSort_id(int sort_id) {
        this.sort_id = sort_id;
    }

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public String getSort_description() {
        return sort_description;
    }

    public void setSort_description(String sort_description) {
        this.sort_description = sort_description;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public int getSort_articles_count() {
        return sort_articles_count;
    }

    public void setSort_articles_count(int sort_articles_count) {
        this.sort_articles_count = sort_articles_count;
    }
}
