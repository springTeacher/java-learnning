package com.xiaoniu.atomic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lhj
 * @date 2019/12/9 16:47
 */
public class ReentrantLockTest {

    private static Lock lock1 = new ReentrantLock();

    private static Lock lock2 = new ReentrantLock();


    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyThread(lock1, lock1));

        Thread thread2 = new Thread(new MyThread(lock2, lock1));




        thread1.start();

        thread2.start();






    }
}
