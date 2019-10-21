package com.web.controller;

import com.web.bo.HelloBO;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihoujing
 * @date 2019/10/21 14:33
 */
@RestController
@RequestMapping("/")
public class HelloController {



    @PostMapping("/hello")
    public void hello(@RequestBody HelloBO helloBO){

        System.err.println("======姓名："+ helloBO.getName()+"年龄："+helloBO.getAge());

    }
}
