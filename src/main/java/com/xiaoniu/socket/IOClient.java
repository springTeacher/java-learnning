package com.xiaoniu.socket;

import java.net.Socket;
import java.util.Date;

/**
 * @author lhj
 * @date 2019/12/13 20:20
 */
public class IOClient {


    public static void main(String[] args) {

        //创建一个线程
        new Thread(() ->{
            try {
                Socket socket = new Socket("127.0.0.1", 8070);

                //每隔2s发送一次
                while (true){
                    socket.getOutputStream().write((new Date()+ "hello world").getBytes());
                    System.out.println("发送成功");
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }).start();




    }
}
