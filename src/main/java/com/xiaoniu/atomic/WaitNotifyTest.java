package com.xiaoniu.atomic;

/**
 * wait和notify实现两个线程间的通讯
 *
 *     wait( )，notify( )，notifyAll( )都不属于Thread类，而是属于Object基础类，也就是每个对象都有wait( )，notify( )，notifyAll( ) 的功能，因为每个对象都有锁，锁是每个对象的基础，当然操作锁的方法也是最基础了。
 *
 *     当需要调用以上的方法的时候，一定要对竞争资源进行加锁，如果不加锁的话，则会报 IllegalMonitorStateException 异常
 *
 *     当想要调用wait( )进行线程等待时，必须要取得这个锁对象的控制权（对象监视器），一般是放到synchronized(obj)代码中。
 *
 *     在while循环里而不是if语句下使用wait，这样，会在线程暂停恢复后都检查wait的条件，并在条件实际上并未改变的情况下处理唤醒通知
 *
 *     调用obj.wait( )释放了obj的锁，否则其他线程也无法获得obj的锁，也就无法在synchronized(obj){ obj.notify() } 代码段内唤醒A。
 *
 *     notify( )方法只会通知等待队列中的第一个相关线程（不会通知优先级比较高的线程）
 *
 *     notifyAll( )通知所有等待该竞争资源的线程（也不会按照线程的优先级来执行）
 *
 *     假设有三个线程执行了obj.wait( )，那么obj.notifyAll( )则能全部唤醒tread1，thread2，thread3，但是要继续执行obj.wait（）的下一条语句，必须获得obj锁，因此，tread1，thread2，thread3只有一个有机会获得锁继续执行，例如tread1，其余的需要等待thread1释放obj锁之后才能继续执行。
 *
 *     当调用obj.notify/notifyAll后，调用线程依旧持有obj锁，因此，thread1，thread2，thread3虽被唤醒，但是仍无法获得obj锁。直到调用线程退出synchronized块，释放obj锁后，thread1，thread2，thread3中的一个才有机会获得锁继续执行。
 *
 * @author lhj
 * @date 2019/12/9 17:35
 */
public class WaitNotifyTest {


    private static Object object = new Object();


    public static void main(String[] args){


        Thread download = new Thread(()->{
            System.out.println("开始下载图片");
            for (int i = 0; i < 101; i+=10) {
                System.out.println("down"+i+"%");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("图片下载成功");

            //唤醒线程
            synchronized (object){
                object.notify();
            }

            System.out.println("开始下载附件");
            for (int i = 0; i < 101; i+=10) {
                System.out.println("附件下载"+i+"%");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("附件下载成功");

        });

        Thread show = new Thread(()->{

            synchronized (object){
                try {
                    //阻塞当前线程，释放锁
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("show:开始展示图片");
            System.out.println("图片展示完毕");

        });


        download.start();
        show.start();









    }



}
