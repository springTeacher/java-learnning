package com.xiaoniu.atomic;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author lhj
 * @date 2019/12/12 15:42
 */
public class MyQueueTest {


    public static void main(String[] args) {


        Queue<String> queue = new LinkedBlockingQueue<>();

//        queue.offer("aaa");
//        queue.offer("bbb");
//        queue.offer("ccc");
        System.out.println(queue);

        String poll = queue.remove();
        System.out.println(poll);

        System.out.println(queue);




    }




}
