package com.xiaoniu.jvm;


import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lihoujing
 * @date 2019/10/11 21:20
 */
public class StackTest {



    private static boolean isFinish = false;

    public static void main(String[] args) {
        Thread download = new Thread(() -> {
            System.out.println("开始下载图片...");
            for (int i = 1; i <= 100; i++) {
                System.out.println("down:" + i + "%");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("图片下载完毕!");
            isFinish = true;
        });

        Thread show = new Thread(() -> {
            System.out.println("开始显示图片...");
            try {
                download.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!isFinish) {
                throw new RuntimeException("图片加载失败!");
            }
            System.out.println("图片显示完毕!");
        });
        download.start();
        show.start();



    }


}
