package com.doromv.filter;

import com.doromv.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-01-20-11:57
 */
public class sysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
        Object user_session = servletRequest1.getSession().getAttribute(Constant.USER_SESSION);
        if(user_session==null){
            servletResponse1.sendRedirect("/error.jsp");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
