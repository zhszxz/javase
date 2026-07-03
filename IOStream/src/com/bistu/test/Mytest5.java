package com.bistu.test;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Mytest5 {
    public static void main(String[] args) throws IOException {
         /*
                需求：把《出师表》的文章顺序进行恢复到一个新文件中。
            */
        BufferedReader br=new BufferedReader(new FileReader("D:\\Java\\idea-WorkSpace\\IOStream\\csb.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("csb2.txt"));

        TreeMap<Integer,String> tm=new TreeMap<>();

        String str;
        while ((str=br.readLine())!=null){
            String[] split = str.split("\\.");
            tm.put(Integer.parseInt(split[0]),split[1]);
        }

        Set<Map.Entry<Integer, String>> entries = tm.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            bw.write(entry.getKey()+""+"."+entry.getValue());
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
