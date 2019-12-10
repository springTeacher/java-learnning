package com.xiaoniu.atomic;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 1.put方法key/value都不能为空
 * 2.ConcurrentHashMap 和 Hashtable 的区别?
 *     实现线程安全的方式不同，从底层数据结构和线程安全的方式（*）
 *    ConcurrentHashMap 1.7及以前分段数组+链表，1.8采用数组+链表/红黑二叉树
 *    Hashtable采用数组+链表，链表为了解决hash冲突
 *
 *    hashtable的put和get方法都使用synchronized同步方法，竞争越激烈性能越低
 *
 *
 *
 * @author lhj
 * @date 2019/12/10 10:14
 */
public class MyConcurrentHashMapTest {

    private static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);

    private static Hashtable<String, String> hashtable = new Hashtable<>();

    private static Map<String, String> hashMap = new HashMap<>();

    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() ->{
            for (int i = 0;i<5000;i++){
                hashtable.put("1"+i,"2");
            }
            latch.countDown();
        }).start();



        new Thread(() ->{
            for (int i = 0;i<5000;i++){
                hashtable.put("a"+i,"2");
            }
            latch.countDown();
        }).start();

        latch.await();
        System.out.println(hashtable.size());



    }


}
