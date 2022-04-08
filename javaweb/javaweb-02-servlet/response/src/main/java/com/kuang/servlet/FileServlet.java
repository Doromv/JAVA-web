package com.kuang.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author shkstart
 * @create 2022-01-15-13:34
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//         1.获取要下载文件的路径
        String realPath = "E:\\IDEA 2021\\javaweb\\javaweb-02-servlet\\response\\target\\classes\\qaq.jpg";
//         2.下载的文件名是啥
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
//         3.设置想办法让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
//         4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
//         5.创建缓冲区
        int len=0;
        byte[] buffer = new byte[1024];
//         6.获取OutputStream
        ServletOutputStream out = resp.getOutputStream();
//         7.将FileOutputStream流写入到buffer缓冲区
//         8.使用OutputStream将缓冲区中的数据输入到客户端
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
