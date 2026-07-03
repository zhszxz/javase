package com.bistu.NetPractice.test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveMessage {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        byte[] bytes = new byte[1024];
        while (true) {
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            byte[] data = dp.getData();
            InetAddress address = dp.getAddress();
            int port = dp.getPort();
            System.out.println("IP为"+address.getHostAddress()+",主机名为"+address.getHostName()+"从"+port+"端口向你发送了以下消息："+new String(data));
        }
    }
}
