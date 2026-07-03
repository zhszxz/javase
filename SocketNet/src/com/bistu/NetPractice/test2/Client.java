package com.bistu.NetPractice.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息
        //绑定ip和端口
        Socket socket = new Socket("127.0.0.1", 10086);
        //发送数据
        OutputStream os = socket.getOutputStream();
        os.write("先帝创业未半而中道崩殂，今天下三分，益州疲敝".getBytes());
        //发送结束标记，表示数据已发完
        socket.shutdownOutput();
        //等待反馈
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int i;
        while ((i=isr.read())!=-1) {
            System.out.print((char) i);
        }
            socket.close();
    }
}
