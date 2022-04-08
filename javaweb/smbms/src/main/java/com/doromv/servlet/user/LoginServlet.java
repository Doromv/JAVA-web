package com.doromv.servlet.user;

import com.doromv.pojo.User;
import com.doromv.service.User.UserServiceImpl;
import com.doromv.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-01-21-12:15
 */
public class LoginServlet extends HttpServlet {
    //servlet:控制层调业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("loginservlet--start...");
        //获取用户名和密码
        String userCode=req.getParameter("userCode");
        String userPassword=req.getParameter("userPassword");
        //和数据库的密码进行对比，调用业务层即可
        UserServiceImpl userService = new UserServiceImpl();
        //查出登入的人
        User user = userService.login(userCode, userPassword);
        if(user!=null){
            //查有此人可以登入
            //将用户的信息放到Session中
            req.getSession().setAttribute(Constant.USER_SESSION,user);
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            //查无此人
            //转发回登入页面，提示密码或账号输入错误
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
