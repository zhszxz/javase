package com.bistu.test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mytest3 {
    public static void main(String[] args) throws IOException {
        /*
            文本文件中有以下的数据：
                2-1-9-4-7-8
            将文件中的数据进行排序，变成以下的数据：
                1-2-4-7-8-9
        */

        //读取文本
        File f1=new File("test\\a.txt");
        FileReader fr=new FileReader(f1);

        StringBuilder sb=new StringBuilder();

        int ch;
        while((ch=fr.read())!=-1){
            sb.append((char)ch);
        }


        //排序
        /*String[] split = sb.toString().split("-");

        ArrayList<Integer> list=new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }

        Collections.sort(list);*/

        //第二种方式
        String[] split = sb.toString().split("-");
        List<Integer> collect = Arrays.stream(split).map(Integer::parseInt).sorted().collect(Collectors.toList());

        String replace = collect.toString().replace(", ", "-");
        ;
        //写出
       FileWriter fw=new FileWriter(new File("b.txt"));
       fw.write(replace.substring(1, replace.length() - 1));

       fw.close();
       fr.close();

    }
}
