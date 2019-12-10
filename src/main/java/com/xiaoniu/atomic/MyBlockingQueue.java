package com.xiaoniu.atomic;

/**
 * 使用Condition实现一个阻塞队列
 * https://www.cnblogs.com/takumicx/p/9338983.html#reentrantlock%E7%AE%80%E4%BB%8B
 * @author lhj
 * @date 2019/12/9 19:03
 */
public class MyBlockingQueue {


    public static void main(String[] args) {

    }

    static final int HASH_BITS = 0x7fffffff;


    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}
