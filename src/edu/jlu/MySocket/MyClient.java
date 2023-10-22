package edu.jlu.MySocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args){
        FirstTest();
    }

    public static void FirstTest() {
        try (Socket socket = new Socket("localhost", 8080);
             Scanner in = new Scanner(System.in)) {
            System.out.println("已经连接成功!");
            System.out.print("请输入需要写入的数据:  ");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(in.nextLine() + "\n");
            writer.flush();
            System.out.println("数据已发送!");


            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("客户端收到的数据是:\t" + reader.readLine());

        } catch (IOException e) {
            System.out.println("连接客户端失败");
            e.printStackTrace();
        } finally {
            System.out.println("客户端结束运行!");
        }
    }
}
