package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/11/26 22:39
 */
@Component
public class Teacher {

    @Autowired
    private Student student2;



    public Teacher(){
        System.out.println("Teacher constructor");
    }


    public Student getStudent() {
        return student2;
    }


}
