package com.bistu.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        //TCP协议，发送数据

        Socket socket = new Socket("127.0.0.1", 10086);

        OutputStream os = socket.getOutputStream();
        os.write("先帝创业未半而中道崩殂，今天下三分，益州疲敝".getBytes(StandardCharsets.UTF_8));

        socket.close();
    }
}
