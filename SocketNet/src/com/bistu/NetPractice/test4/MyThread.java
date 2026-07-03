package com.bistu.NetPractice.test4;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyThread implements Runnable {
    Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //读取数据并写入本地文件
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

            FileOutputStream fos = new FileOutputStream("Server\\" + UUID.randomUUID().toString().replace("-", "") + ".jpg");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
                bos.flush();
            }
            bos.close();
            //发送反馈
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("上传成功！");
            bw.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}




