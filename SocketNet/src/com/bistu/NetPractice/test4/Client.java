package com.bistu.NetPractice.test4;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器。接收服务器的反馈。
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈。


        //绑定ip和端口
        Socket socket = new Socket("127.0.0.1", 10086);
        //读取本地文件并发送
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Client\\a.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream((socket.getOutputStream()));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
            bos.flush();
        }
        bis.close();
        //发送结束标记，表示数据已发完
        socket.shutdownOutput();
        //等待反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.print(br.readLine());
        socket.close();
    }
}

