package com.web.controller;

import com.web.aspect.ActionLogger;
import com.web.bo.HelloBO;
import com.xiaoniu.common.core.support.RedisRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author lihoujing
 * @date 2019/10/21 14:33
 */
@RestController
@RequestMapping("/")
public class HelloController {



    @PostMapping("/hello")
    @ActionLogger(moduleName = "查询", actionType = "query")
    public HelloBO hello(@RequestBody HelloBO helloBO){

        helloBO.setDate(new Date());


        RedisRepository.incr("kkkey");
        RedisRepository.expire("kkkey",10 * 60);


        return helloBO;

    }
}
