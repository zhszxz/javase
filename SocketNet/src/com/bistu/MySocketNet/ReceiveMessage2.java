package com.bistu.MySocketNet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveMessage2 {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(10086);

        while (true) {

            //2.接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);

            //3.拆包
            System.out.println("IP为" + dp.getAddress().getHostAddress() + ",主机名为"+dp.getAddress().getHostName()+
                    "的主机从"+dp.getPort()+"端口向你发送了一条数据："+new String(dp.getData()));
        }

    }
}
