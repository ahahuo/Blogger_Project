package cn.wd.dao;

import cn.wd.model.Article;
import cn.wd.utils.jdbcUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticleDao {
    //添加文章
    public boolean addArticle(Article article){
        Connection conn=null;
        PreparedStatement prestmt=null;
        ResultSet rs=null;
        try{
            //获取连接
            conn= jdbcUtil.getConnection();
            //创建sql语句
            String sql="insert into articles(article_title,article_content,article_date)"+"values(?,?,?)";
            prestmt=conn.prepareStatement(sql);

            prestmt.setString(1,article.getArticle_title());
            prestmt.setString(2,article.getArticle_content());
            prestmt.setString(3,article.getArticle_date());
            int num=prestmt.executeUpdate();
            if (num>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(rs,prestmt,conn);
        }
        return false;
    }
    //获取全部文章
    public ArrayList<Article> getArticles(){
        Connection conn=null;
        PreparedStatement prestmt=null;
        ResultSet rs=null;
        ArrayList<Article> list=new ArrayList<Article>();
        try{
            //获得数据库连接
            conn= jdbcUtil.getConnection();
            String sql="select * from articles";
            //创建执行SQL语句的prestmt对象
            prestmt=conn.prepareStatement(sql);
            rs=prestmt.executeQuery();
            //处理结果集
            while (rs.next()){
                Article article=new Article();
                article.setArticle_id(rs.getInt("article_id"));
                article.setArticle_title(rs.getString("article_title"));
                article.setArticle_content(rs.getString("article_content"));
                article.setArticle_views(rs.getInt("article_views"));
                article.setArticle_comment_count(rs.getInt("article_comment_count"));
                article.setArticle_date(rs.getString("article_date"));
                article.setArticle_like_count(rs.getInt("article_like_count"));
                article.setIs_delete(rs.getBoolean("is_delete"));

                list.add(article);
            }
            return list;
            }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(rs,prestmt,conn);
        }
        return null;
    }
}
