package com.bistu.MySocketNet;

import java.io.IOException;
import java.net.*;

public class SendMessage1 {
    public static void main(String[] args) throws IOException {
        //发送数据


        //1.创建DatagramSocket对象(快递公司)
        //细节：
        //绑定端口，以后我们就是通过这个端口往外发送
        //空参：所有可用的端口中随机一个进行使用
        //有参：指定端口号进行绑定
        DatagramSocket ds=new DatagramSocket();
        String str="華生先生，快過來，我需要你！";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //打包数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, 1024);

        //发送数据包
        ds.send(datagramPacket);
        //释放资源
        ds.close();


    }
}
