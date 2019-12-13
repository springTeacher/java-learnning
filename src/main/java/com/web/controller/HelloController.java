package com.web.controller;

import com.web.aspect.ActionLogger;
import com.web.bo.HelloBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihoujing
 * @date 2019/10/21 14:33
 */
@RestController
@RequestMapping("/")
public class HelloController {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        list.parallelStream().forEach(e -> list2.add(e + 3));
        System.out.println(list2.size());
    }


    @GetMapping("/hello")
    @ActionLogger(moduleName = "查询", actionType = "query")
    public HelloBO hello(){

        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        List<Integer> list2 =  new ArrayList<>();
        list.parallelStream().forEach(e -> list2.add(e + 3));
        System.out.println(list2.size());
        return null;

    }

    @Autowired
    private RestTemplate restTemplate;


   @GetMapping("/rest")
    public  ResponseEntity<String> restT(){

       ResponseEntity<String> forEntity = restTemplate.getForEntity("http://127.0.0.1:8076/test?data=中国", String.class);
       return forEntity;
    }

    @GetMapping("/test")
    public String testSendPost(String data){
        return "测试成功:"+data;
    }

}
