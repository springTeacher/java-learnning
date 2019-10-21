package com.xiaoniu.jdk;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author lihoujing
 * @date 2019/10/15 11:09
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        blockingQueue.add("张三");

        System.out.println(blockingQueue);


        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();

        map.get("haha");


    }
}
