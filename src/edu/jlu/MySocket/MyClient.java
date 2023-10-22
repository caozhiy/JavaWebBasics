package edu.jlu.MySocket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
//        FirstTest();
        TransmitFile();
    }

    public static void FirstTest() {

        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        try (Socket socket = new Socket("localhost", 8080);
             Scanner in = new Scanner(System.in)) {
            System.out.println("已经连接成功!");
            System.out.print("请输入需要写入的数据:  ");
            writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(in.nextLine() + "\n");
            writer.flush();
            System.out.println("数据已发送!");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("客户端收到的数据是:\t" + reader.readLine());


        } catch (IOException e) {
            System.out.println("连接客户端失败");
            e.printStackTrace();
        } finally {

            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("客户端结束运行!");
        }
    }

    public static void TransmitFile() {

        OutputStream output = null;
        try (Socket socket = new Socket("localhost", 8080);
             BufferedInputStream input = new BufferedInputStream(new FileInputStream("src/resource/test.txt"))) {
            output = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = input.read(bytes)) != -1) {
                output.write(bytes, 0, len);
            }
            output.flush();
            System.out.println("客户端传输完毕!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (output != null)
                    output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("客户端停止运行......");
        }

    }
}
