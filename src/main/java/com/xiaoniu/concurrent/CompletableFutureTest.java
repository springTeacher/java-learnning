package com.xiaoniu.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lhj
 * @date 2019/12/19 13:48
 */
public class CompletableFutureTest {


    public static void main(String[] args) {


        long start = System.currentTimeMillis();


        ExecutorService executorService = Executors.newCachedThreadPool();


        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                System.err.println("异常");
            }
            return "商品详情";
        }, executorService);

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                System.err.println("异常");
            }
            return "卖家信息";
        }, executorService);

        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                System.err.println("异常");
            }
            return "库存信息";
        }, executorService);

        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                System.err.println("异常");
            }
            return "订单信息";
        }, executorService);

        CompletableFuture.allOf(futureA, futureB, futureC, futureD).join();


        System.out.println(futureA.join() + futureB.join() + futureC.join() + futureD.join());
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));





    }




//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//
//
//        Future<String> submit = threadPool.submit(() -> {
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            return "=======";
//
//        });
//
//
//        System.out.println("做其他事情");
//
//        String s = submit.get();
//
//        System.out.println(s);
//
//        System.out.println("拿到结果后继续做另外的事情");
//
//    }
}
