package com.bistu.Multicast;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendMessage {
    public static void main(String[] args) throws IOException {
          /*
            组播发送端代码
        */

        MulticastSocket ms = new MulticastSocket();

        String str = "你好";


        byte[] bytes = str.getBytes();
        InetAddress target = InetAddress.getByName("224.0.0.1");

        //打包数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, target, 10086);

        //发送数据包
        ms.send(datagramPacket);

        //释放资源
        ms.close();
    }
}
