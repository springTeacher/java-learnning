package com.web.controller;

import com.google.common.collect.Lists;
import com.web.aspect.ActionLogger;
import com.web.bo.HelloBO;
import com.xiaoniu.architecture.spring.boot.autoconfigure.redis.support.RedisRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lihoujing
 * @date 2019/10/21 14:33
 */
@RestController
@RequestMapping("/")
public class HelloController {


    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        List<Integer> list2 = Lists.newArrayList();
        list.parallelStream().forEach(e -> list2.add(e + 3));
        System.out.println(list2.size());
    }


    @GetMapping("/hello")
    @ActionLogger(moduleName = "查询", actionType = "query")
    public HelloBO hello(){

        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        List<Integer> list2 = Lists.newArrayList();
        list.parallelStream().forEach(e -> list2.add(e + 3));
        System.out.println(list2.size());
        return null;

    }
}
