package com.kuang.servlet;

import com.sun.glass.ui.Size;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author shkstart
 * @create 2022-01-15-19:37
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    如何让浏览器五秒刷新一次
    resp.setHeader("refresh","5");
//    在内存中创建一个图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_BGR);
//    在图片上获取一根“笔”
        Graphics2D pen =(Graphics2D) image.getGraphics();
//     设置图片的背景颜色
        pen.setColor(Color.WHITE);
        pen.fillRect(0,0,80,20);
//        给图片写数据
        pen.setColor(Color.BLUE);
        pen.setFont(new Font(null, Font.BOLD, 20));
        pen.drawString(makeNum(),0,20);
//        告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
//        网站存在缓存，不让浏览器缓存
        resp.setHeader("expires","-1");
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Program","no-cache");
//        把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
private String makeNum(){
    Random random = new Random();
    String num=" "+random.nextInt(9999999);
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 7-num.length(); i++) {
     sb.append("0");
    }
    String s=sb.toString()+num;
    return s;
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
