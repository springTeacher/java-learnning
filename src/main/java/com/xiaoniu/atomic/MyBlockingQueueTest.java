package com.xiaoniu.atomic;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * 问题：有两个线程A,B,  A线程每200ms就生成一个[0,100]之间的随机数， B线程每2S中打印出A线程所产生的增量随机数。
 *
 *
 * offer(E e): 将给定的元素设置到队列中，如果设置成功返回true, 否则返回false. e的值不能为空，否则抛出空指针异常。
 * offer(E e, long timeout, TimeUnit unit): 将给定元素在给定的时间内设置到队列中，如果设置成功返回true, 否则返回false.
 * add(E e): 将给定元素设置到队列中，如果设置成功返回true, 否则抛出异常。如果是往限定了长度的队列中设置值，推荐使用offer()方法。
 * put(E e): 将元素设置到队列中，如果队列中没有多余的空间，该方法会一直阻塞，直到队列中有多余的空间。
 * take(): 从队列中获取值，如果队列中没有值，线程会一直阻塞，直到队列中有值，并且该方法取得了该值。
 * poll(long timeout, TimeUnit unit): 在给定的时间里，从队列中获取值，如果没有取到会抛出异常。
 * remainingCapacity()：获取队列中剩余的空间。
 * remove(Object o): 从队列中移除指定的值。
 * contains(Object o): 判断队列中是否拥有该值。
 * drainTo(Collection c): 将队列中值，全部移除，并发设置到给定的集合中。
 *
 *
 * BlockingQueue通过ReentrantLock保证线程安全的
 *
 * @author lhj
 * @date 2019/12/9 21:01
 */
public class MyBlockingQueueTest {
    /**
     * 初始化容量为10的队列
     */
    private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);


    public static void main(String[] args) {


        ScheduledExecutorService product = Executors.newScheduledThreadPool(1);

        Random random = new Random();

        product.scheduleAtFixedRate(() -> {
            int value = random.nextInt(101);
            try{
                //offer()方法就是往队列的尾部设置值
                blockingQueue.offer(value);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            //每100毫秒执行线程
        }, 0, 200, TimeUnit.MILLISECONDS);


        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(2000);
                    System.out.println("开始取值");
                    List<Integer> list = new LinkedList<>();
                    //drainTo()将队列中的值全部从队列中移除，并赋值给对应集合
                    blockingQueue.drainTo(list);
                    list.forEach(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();





    }



}
