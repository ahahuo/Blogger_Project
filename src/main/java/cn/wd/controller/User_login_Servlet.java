package cn.wd.controller;

import cn.wd.dao.UserDao;
import cn.wd.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_do")
public class User_login_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao ud=new UserDao();

        //获得登录页面传过来的用户名和密码
        String user_email=request.getParameter("user_email");
        String user_password=request.getParameter("user_password");

        String sql_user_password=ud.getLogin(user_email);

        if (sql_user_password.equals(user_password)){
            String json="{\"isSuccess\": 1}";
            response.getWriter().print(json);
        } else {
            String json="{\"isSuccess\": 0}";
            response.getWriter().print(json);
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
