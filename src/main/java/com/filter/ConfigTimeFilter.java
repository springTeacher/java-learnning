package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lhj
 * @date 2019/12/16 18:36
 */
public class ConfigTimeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        System.out.println("开始执行过滤器ConfigTimeFilter");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("【过滤器】耗时ConfigTimeFilter " + (System.currentTimeMillis() - start));
        System.out.println("结束执行过滤器ConfigTimeFilter");
    }
}
