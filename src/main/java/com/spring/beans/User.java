package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/11/27 11:45
 */
@Component
public class User {

    @Autowired
    private Order order;


    public User() {

        System.out.println("user");
    }
}
