package com.bistu;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class test4 {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。
            第三次必定是张三同学

          运行效果：
            第一次运行程序：随机同学姓名1
            第二次运行程序：随机同学姓名2
            第三次运行程序：张三
            …
        */
        //读取同学信息到arraylist
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\idea-WorkSpace\\IOStreamTeat\\names.txt"));
        ArrayList<String> students = new ArrayList<>();
        String stuinfo = "";
        while ((stuinfo = br.readLine()) != null) {
            students.add(stuinfo);
        }
        br.close();

        //读取点名次数
        BufferedReader br2 = new BufferedReader(new FileReader("test4.txt"));
        int count = Integer.parseInt(br2.readLine());
        br2.close();

        //如果是第三次，直接输出张三，否则随机点名
        if (count == 2) {
            count++;
            System.out.println("第3次点名:张三");
        } else {
            Random r = new Random();
            int index = r.nextInt(students.size());
            String name = students.get(index).split("-")[0];
            count++;
            System.out.println("第" + count + "次点名:" + name);
        }

        //写出点名次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("test4.txt"));
        bw.write(count + "");
        bw.close();

    }
}
