package edu.jlu.MySocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("正在等待客户端连接……");
            Socket client = server.accept();
            System.out.println("客户端已连接,IP地址为" + client.getInetAddress().getHostAddress());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
