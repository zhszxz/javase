package com.bistu.MySocketNet;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendMessage2 {
    public static void main(String[] args) throws IOException {
        /*
            按照下面的要求实现程序
                UDP发送数据：数据来自于键盘录入，直到输入的数据是over，发送数据结束
                UDP接收数据：因为接收端不知道发送端什么时候停止发送，故采用死循环接收
        */

        DatagramSocket ds = new DatagramSocket();

        while (true) {

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

            if ("over".equals(str)) {
                break;
            }

            byte[] bytes = str.getBytes();
            InetAddress target = InetAddress.getByName("127.0.0.1");

            //打包数据
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, target, 10086);

            //发送数据包
            ds.send(datagramPacket);
        }
        //释放资源
        ds.close();
    }
}
