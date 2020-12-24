package cn.wd.controller;

import cn.wd.dao.ArticleDao;
import cn.wd.model.Article;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Articles_diff_Servlet")
public class Articles_diff_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type=request.getParameter("type");
        switch (type){
            case "life": type="生活";break;
            case "share": type="分享";break;
            case "technology": type="技术";break;
            case "diary": type="日记心事";break;
            default:break;
        }
        System.out.println(type);

        ArticleDao articleDao=new ArticleDao();
        //通过传入不同参数获取不同类型所有文章
        ArrayList<Article> articles=articleDao.getArticles_diff(type);
        //java对象转成json
        String json= JSON.toJSONString(articles);

        //将json返回给客户端
        //设置json返回数据的编码，防止前端乱码
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);

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
