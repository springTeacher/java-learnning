package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/11/27 11:45
 */
@Component
public class User {


    private Teacher teacher;

    public User(Teacher teacher){
        this.teacher = teacher;
    }


    @Autowired
    private EnvironmentAware environmentAware;

    @Autowired
    private ApplicationContextAware applicationContextAware;





    public void getTeacher(){
        System.out.println(teacher);
    }
}
