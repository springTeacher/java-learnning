package com.xiaoniu.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author lhj
 * @date 2019/12/9 16:48
 */
public class MyThread implements Runnable {

    private Lock firstLock;

    private Lock secondLock;

    public MyThread(Lock firstLock, Lock secondLock){
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }


    @Override
    public void run() {
        try {
            firstLock.lock();
            TimeUnit.SECONDS.sleep(2);
            secondLock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            firstLock.unlock();
            secondLock.unlock();
            System.out.println(Thread.currentThread().getName()+"正常结束!");
        }

    }
}
