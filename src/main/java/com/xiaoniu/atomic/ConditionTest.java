package com.xiaoniu.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 主线程等待子线程
 *
 * @author lhj
 * @date 2019/12/9 17:10
 */
public class ConditionTest {

    private static Lock lock = new ReentrantLock(true);

    private static Condition condition = lock.newCondition();




    public static void main(String[] args) {

        //上锁
        lock.lock();
        //启动一个子线程
        new Thread(() ->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                condition.signal();
                System.out.println("子线程通知主线程");
            }finally {
                lock.unlock();
            }

        }).start();

        //主线程等待
        System.out.println("主线程等待通知");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        System.out.println("主线程恢复运行");








    }
}
