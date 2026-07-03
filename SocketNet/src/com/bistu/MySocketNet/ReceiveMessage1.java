package com.bistu.MySocketNet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMessage1 {
    public static void main(String[] args) throws IOException {
        //接收数据

        //1.创建DatagramSocket对象（快递公司）
        //细节：
        //在接收的时候，一定要绑定端口
        //而且绑定的端口一定要跟发送的端口保持一致
        DatagramSocket ds = new DatagramSocket(1024);

        //2.接收数据
        byte[] bytes = new byte[44];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        ds.receive(dp);

        //3.拆包
        System.out.println("收到了以下数据："+new String(dp.getData()));
        System.out.println("该数据是从"+dp.getAddress()+"的"+dp.getPort()+"端口发出的");

        ds.close();
    }
}
