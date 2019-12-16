package com.spring.test;

import com.spring.beans.User;
import com.spring.configuration.SpringAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lhj
 * @date 2019/11/26 20:06
 */
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);


        User user = context.getBean(User.class);

        user.getTeacher();


    }
}
