package com.xiaoniu.atomic;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * ConcurrentLinkedQueue非阻塞线程安全的无界队列，通过CAS实现；
 * BlockingQueue阻塞线程安全的有界队列，通过ReentrantLock实现。
 *
 *
 * @author lhj
 * @date 2019/12/10 17:31
 */
public class MyConcurrentLinkedQueueTest {


    private static ConcurrentSkipListMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();


    public static void main(String[] args) {

        String s = concurrentSkipListMap.get("aaa");
        System.out.println(s);


    }
}
