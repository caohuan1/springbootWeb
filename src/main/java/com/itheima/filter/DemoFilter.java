package com.itheima.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
//@WebFilter(urlPatterns = "/*")//表示对所有请求路径开启拦截
public class DemoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {
        System.out.println("DemoFilter 拦截到了请求，执行拦截前的逻辑...");
        Chain.doFilter(Request,Response);
        System.out.println("DemoFilter 执行拦截后的逻辑...");
    }
    @Override//初始化方法，只会被调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了。");
        Filter.super.init(filterConfig);
    }
    @Override//销毁方法，只调用一次
    public void destroy() {
        System.out.println("destroy 销毁方法执行了。");
        Filter.super.destroy();
    }
}
