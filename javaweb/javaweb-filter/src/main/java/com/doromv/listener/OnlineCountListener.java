package com.doromv.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author shkstart
 * @create 2022-01-19-20:17
 */
public class OnlineCountListener implements HttpSessionListener {
    @Override
    //一但session创建就会触发该方法
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlinecount= (Integer) servletContext.getAttribute("OnlineCount");
        if(onlinecount==null){
            onlinecount=new Integer(1);
        }else {
            int count = onlinecount.intValue();
            onlinecount=new Integer(count++);
        }
        servletContext.setAttribute("OnlineCount",onlinecount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlinecount= (Integer) servletContext.getAttribute("OnlineCount");
        if(onlinecount==null){
            onlinecount=new Integer(0);
        }else {
            int count = onlinecount.intValue();
            onlinecount=new Integer(count--);
        }
        servletContext.setAttribute("OnlineCount",onlinecount);
    }
}
