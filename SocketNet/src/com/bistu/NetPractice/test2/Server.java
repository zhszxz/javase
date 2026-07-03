package com.bistu.NetPractice.test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        //绑定端口
        ServerSocket ss = new ServerSocket(10086);
        //等待连接
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        //读取数据
        String str=null;
        //read方法细节：方法会从连接通道中读取数据，读到结束标记，此处的循环才会停止
        //否则，程序就会一直停在read方法这里，等待读取下面的数据
        while ((str=br.readLine())!=null){
            System.out.print(str);
        }
        //发送反馈
        OutputStream os = socket.getOutputStream();
        os.write("已收到你的消息".getBytes());

        socket.close();
        ss.close();
    }
}
