package com.bistu.BufferedStream;

import java.io.*;

public class BufferedRWer1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("a.txt"));

        String s = br.readLine();
        System.out.println(s);

        String s1 = br.readLine();
        System.out.println(s1);

        br.close();


        BufferedWriter bw=new BufferedWriter(new FileWriter("c.txt"));
        bw.write("随便写点");
        bw.newLine();
        bw.write("换行了吗");
        bw.close();
    }
}
