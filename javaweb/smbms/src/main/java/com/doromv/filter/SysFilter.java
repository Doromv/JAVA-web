package com.doromv.filter;

import com.doromv.pojo.User;
import com.doromv.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-01-22-10:56
 */
public class SysFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute(Constant.USER_SESSION);
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }else{
            filterChain.doFilter(req,resp);
        }
    }

    public void destroy() {

    }
}
