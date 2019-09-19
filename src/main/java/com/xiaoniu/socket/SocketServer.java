package com.xiaoniu.socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author lihoujing
 * @date 2019/9/16 22:03
 */
public class SocketServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
