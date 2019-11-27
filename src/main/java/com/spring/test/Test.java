package com.spring.test;

import com.spring.beans.Teacher;
import com.spring.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lhj
 * @date 2019/11/26 20:06
 */
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        Teacher teacher = context.getBean(Teacher.class);


        System.out.println(teacher.getStudent());


    }
}
