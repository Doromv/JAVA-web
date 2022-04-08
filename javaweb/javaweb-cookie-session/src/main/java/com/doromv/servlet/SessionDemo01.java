package com.doromv.servlet;

import com.doromv.pojo.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-01-17-13:46
 */
public class SessionDemo01 extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        session.setAttribute("name",new Person("zr",20));
        String id = session.getId();
        if (session.isNew()){
            resp.getWriter().print("session创建成功，ID："+id);
        }else{
            resp.getWriter().print("session已经在服务器中创建了，ID："+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
