package com.xiaoniu.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lhj
 * @date 2019/12/9 15:49
 */
public class AtomicTest {

    private static int m = 0;

    private static CountDownLatch latch = new CountDownLatch(2);


//    public static void main(String[] args) throws InterruptedException {
//
//        new Thread(()->{
//            for (int i=0; i<50000;i++){
//                synchronized (AtomicTest.class){
//                    m ++;
//                }
//
//            }
//            latch.countDown();
//
//        }).start();
//
//        new Thread(()->{
//            for (int i=0; i<50000;i++){
//                synchronized (AtomicTest.class){
//                    m ++;
//                }
//            }
//            latch.countDown();
//
//        }).start();
//
//        latch.await();
//        System.out.println("m的结果值："+m);
//    }


    private static AtomicInteger atomicInteger = new AtomicInteger();

//    public static void main(String[] args) throws InterruptedException {
//
//        new Thread(() ->{
//            for (int i =0;i<5000;i++){
//                atomicInteger.incrementAndGet();
//            }
//            latch.countDown();
//        }).start();
//
//
//
//        new Thread(() ->{
//            for (int i =0;i<5000;i++){
//                atomicInteger.incrementAndGet();
//            }
//            latch.countDown();
//        }).start();
//
//
//        latch.await();
//        System.out.println("atomicInteger的结果值："+atomicInteger.get());
//    }


    private static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {

        new Thread(() ->{
            for (int i =0;i<50000;i++){
                incrM();
            }
            latch.countDown();
        }).start();

        new Thread(() ->{
            for (int i =0;i<50000;i++){
                incrM();
            }
            latch.countDown();
        }).start();


        latch.await();
        System.out.println("m的结果值："+m);
    }

    private static void incrM(){
        lock.lock();
         m++;
        lock.unlock();

    }







}
