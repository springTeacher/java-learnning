package com.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lhj
 * @date 2019/12/16 18:46
 */
public class TimeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("【拦截器】耗时postHandle " + (System.currentTimeMillis()- start));
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("【拦截器】耗时afterCompletion " + (System.currentTimeMillis() - start));
        System.out.println("异常信息 " + ex);
    }
}
