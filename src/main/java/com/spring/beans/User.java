package com.spring.beans;

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





    public void getTeacher(){
        System.out.println(teacher);
    }
}
