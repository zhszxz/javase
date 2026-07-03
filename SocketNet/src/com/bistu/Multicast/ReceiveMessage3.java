package com.bistu.Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMessage3 {
    public static void main(String[] args) throws IOException {

        MulticastSocket ms = new MulticastSocket(10086);
        InetAddress address = InetAddress.getByName("224.0.0.2");
        ms.joinGroup(address);


        //2.接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ms.receive(dp);

        //3.拆包
        System.out.println("IP为" + dp.getAddress().getHostAddress() + ",主机名为" + dp.getAddress().getHostName() +
                "的主机从" + dp.getPort() + "端口向你发送了一条数据：" + new String(dp.getData()));
    }


}
