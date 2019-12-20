package com.web.controller;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.web.bo.HelloBO;
import com.xiaoniu.architecture.commons.core.util.DateUtils;
import com.xiaoniu.architecture.commons.core.util.JSONUtils;
import com.xiaoniu.architecture.spring.boot.autoconfigure.redis.support.RedisRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lhj
 * @date 2019/12/20 11:22
 */
@RestController
@RequestMapping("/redis")
public class RedisController {




    @GetMapping("/test")
    public void test(){

        HelloBO helloBO = new HelloBO();
        helloBO.setName("张三");
        helloBO.setAge(18);
        helloBO.setDate(new Date());

        RedisRepository.hset("hash", "name",helloBO.getName());
        RedisRepository.hset("hash", "age",String.valueOf(helloBO.getAge()));
        RedisRepository.hset("hash", "date", DateUtils.format(helloBO.getDate(), DateUtils.DATE_TIME_PATTERN));


        RedisRepository.set("string", JSONUtils.toJSONString(helloBO), 60*60);
        RedisRepository.set("string", JSONUtils.toJSONString(helloBO), 60*60);


        RedisRepository.rpush("rpush", JSONUtils.toJSONString(helloBO));
        RedisRepository.rpush("rpush", JSONUtils.toJSONString(helloBO));

        RedisRepository.sadd("sadd", JSONUtils.toJSONString(helloBO));

        double a = 4.34d;
        RedisRepository.zadd("zset", JSONUtils.toJSONString(helloBO), a);
        RedisRepository.zadd("zset", JSONUtils.toJSONString(helloBO), a);




    }








}
