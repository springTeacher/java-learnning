package com.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 配置filter有两种方式：
 * 1.@Component
 *   @WebFilter(urlPatterns = "/*")
 * 2.通过配置类注册一个FilterRegistrationBean
 *
 * @author lhj
 * @date 2019/12/16 18:28
 */
@Component
@WebFilter(urlPatterns = "/*")
public class TimeFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("开始执行过滤器TimeFilter");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("【过滤器】耗时TimeFilter " + (System.currentTimeMillis() - start));
        System.out.println("结束执行过滤器TimeFilter");
    }
}
