package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lhj
 * @date 2019/11/27 11:45
 */
@Component
public class Order {

    @Autowired
    private User user;



    public Order(){
        System.out.println("order");
    }
}
