package com.web.controller;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * @author lhj
 * @date 2019/11/28 15:41
 */
@RestController
public class ThreadPoolSchedulerController {



    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @PostConstruct
    public void init(){
        threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(2);
        threadPoolTaskScheduler.setThreadNamePrefix("matching-");
        threadPoolTaskScheduler.setErrorHandler(e -> System.out.println("错误信息如下："+e));
        threadPoolTaskScheduler.initialize();
    }



    @PreDestroy
    public void destroy(){
        threadPoolTaskScheduler.destroy();
    }



    @GetMapping("/scheduler")
    public void scheduler(){
        threadPoolTaskScheduler.schedule(() -> System.out.println(22), new Date());
    }


//    public static void main(String[] args) {
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
//    }





}
