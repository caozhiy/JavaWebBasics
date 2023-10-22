package edu.jlu.MySocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class MySocket {
    public static void main(String[] args) {
        SecondTest();
    }

    public static void FirstTest() {
        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("服务器正在连接......");
            Socket client = socket.accept();
            System.out.println("客户端已连接......\t IP地址: " + client.getInetAddress().getHostAddress());

            // 接收输入的数据Stream
            InputStreamReader reader = new InputStreamReader(client.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println("服务器端收到的数据是:" + bufferedReader.readLine());


            // 服务端向客户端输出数据
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            writer.write("服务器已经收到消息!");
            writer.newLine();
            writer.flush();


            client.close(); // 释放连接的客户端socket
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("服务器端结束运行!");
        }
    }

    public static void SecondTest() {

        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("服务器正在连接...");
            Socket client = socket.accept();
            client.setKeepAlive(true);
            client.setSoTimeout(2000);  // 设置超时时间


        } catch (IOException e) {
            System.out.println("client is timeout.");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Server has closed.");
        }
    }
}
