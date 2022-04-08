package com.doromv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author shkstart
 * @create 2022-01-17-12:35
 */
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        服务器告诉你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了
//        解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        Cookie，服务器端从客户端获取
        Cookie[] cookies = req.getCookies();//这里返回数组，说明cookie可以存在多个
//        判断cookie是否存在
        //        判断cookie是否存在
        if(cookies!=null){
//        如果存在怎么办
            out.write("你上一次访问的时间是：");
            for (int i=0;i<cookies.length;i++) {
                Cookie cookie = cookies[i];
//               获取cookie的名字
                if (cookie.getName().equals("lastlogintime")) {
//                   获取cookie中的值并且转化为long
                    long lastlogintime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastlogintime);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("这是你第一次访问");
        }
        //        服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("lastlogintime",System.currentTimeMillis()+"");
        // 设置cookie的有效期为一天，如果不设置有效期，则关闭浏览器cookie就失效
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
