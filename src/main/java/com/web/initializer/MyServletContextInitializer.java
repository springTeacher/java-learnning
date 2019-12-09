package com.web.initializer;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author lhj
 * @date 2019/12/9 9:28
 */
@Component
public class MyServletContextInitializer implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("MyServletContextInitializer");

    }
}
