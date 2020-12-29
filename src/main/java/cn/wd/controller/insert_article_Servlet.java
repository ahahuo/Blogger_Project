package cn.wd.controller;

import cn.wd.dao.ArticleDao;
import cn.wd.model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/insert_article_Servlet_do")
public class insert_article_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao ad=new ArticleDao();
        //获得登录页面传过来的用户名和密码
        String article_title=request.getParameter("article_title");
        String sort_name=request.getParameter("sort_name");
        String article_content=request.getParameter("article_content");
        //设置编码
        String str1 = new String(article_title.getBytes("ISO8859_1"), "UTF-8");
        String str2 = new String(sort_name.getBytes("ISO8859_1"), "UTF-8");
        String str3 = new String(article_content.getBytes("ISO8859_1"), "UTF-8");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        if(str1.length()==0||str2.length()==0||str3.length()==0){
            String json="{\"isSuccess\": \"发布内容不能为空\"}";
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(json);
        }else{
            Article article=new Article();
            //获取当前时间
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String date=format.format(new Date());

            article.setArticle_title(str1);
            article.setArticle_content(str3);
            article.setArticle_date(date);
            article.setSort_name(str2);
            Boolean b=ad.addArticle(article);
            if(b){
                String json="{\"isSuccess\": \"发布成功\"}";
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(json);
            }else{
                String json="{\"isSuccess\": \"对不起，发布失败\"}";
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(json);
            }
        }

        //允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
    }
}
