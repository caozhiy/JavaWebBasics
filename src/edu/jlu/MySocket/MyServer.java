package edu.jlu.MySocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        TransmitFile();
    }

    public static void FirstConnect() {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("正在等待客户端连接……");
            Socket client = server.accept();
            System.out.println("客户端已连接,IP地址为" + client.getInetAddress().getHostAddress());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void TransmitFile() {

        Socket client = null;
        BufferedInputStream input = null;

        try (ServerSocket server = new ServerSocket(8080);
             FileOutputStream output =new FileOutputStream("src\\resource\\aim.txt")) {
            {
                System.out.println("服务器正在等待连接......");
                client = server.accept();
                System.out.println("客户端已连接服务器, IP地址:  " + client.getInetAddress().getHostAddress());
                input = new BufferedInputStream(client.getInputStream());

                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = input.read(bytes)) != -1) {
                    output.write(bytes, 0, len);
                }
                System.out.println("服务器传输完毕!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null)
                    client.close();
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("服务器停止运行......");
        }
    }
}

