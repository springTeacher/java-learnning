package com.xiaoniu.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * CountDownLatch允许一个或多个线程等待其他线程完成操作
 * 常用于多个线程之间的协调工作。
 *
 * @author lihoujing
 * @date 2019/10/14 17:31
 */
public class CountDownLatchTest {


    private static ExecutorService threadPool = Executors.newFixedThreadPool(7);

    private static CountDownLatch latch = new CountDownLatch(7);

    /**
     * 假设我们现在有这样一个需求：
     * 1.从数据库获取数据
     * 2.对这批数据进行处理
     * 3.保存这批数据
     * @param args
     */
    public static void main(String[] args) {

        // 1. 模拟从数据库获取数据
        int[] data = {2,1,6,4,3,9,8};
        System.out.println("数据准备完毕");

        // 2. 数据处理
        IntStream.range(0, data.length).forEach(i -> {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread() + "处理第" + (i + 1) + "条数据");
                int value = data[i];
                if (value % 2 == 0) {
                    data[i] = value * 2;
                } else {
                    data[i] = value * 10;
                }
                latch.countDown();
            });

        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有数据都处理完了");
        // 关闭线程池
        threadPool.shutdown();
        // 3. 保存数据
        System.out.println("保存数据");




    }
}
