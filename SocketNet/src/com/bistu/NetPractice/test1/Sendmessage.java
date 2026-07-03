package com.bistu.NetPractice.test1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Sendmessage {
    //客户端：多次发送数据
    //服务器：接收多次接收数据，并打印
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        while (true){
            String str = sc.nextLine();
            byte[] bytes = str.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 10086);
            ds.send(dp);
        }
    }
}
