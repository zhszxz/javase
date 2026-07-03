package com.bistu.NetPractice.test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        //绑定端口
        ServerSocket ss = new ServerSocket(10086);
        //等待连接
        Socket socket = ss.accept();
        //读取数据并写入本地文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        FileOutputStream fos=new FileOutputStream("Server\\"+ UUID.randomUUID().toString().replace("-","") +".jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int len;
        byte[] bytes = new byte[1024];
        while ((len=bis.read(bytes))!=-1){
           bos.write(bytes,0,len);
           bos.flush();
        }
        bos.close();
        //发送反馈
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功！");
        bw.flush();

        socket.close();
        ss.close();
    }
}
