package com.doromv.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-01-19-17:13
 */
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("CharacterEncodingFilter执行前……");
        filterChain.doFilter(servletRequest,servletResponse);//让我们的请求继续走，如果不写，程序到这里就被拦截停止了
        System.out.println("CharacterEncodingFilter执行后……");
    }

    @Override
    public void destroy() {
        System.out.println("已销毁");
    }
}
