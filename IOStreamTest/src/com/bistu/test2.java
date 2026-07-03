package com.bistu;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class test2 {
    public static void main(String[] args) throws IOException {
         /*需求：
            需求：
                有一个文件里面存储了班级同学的信息，每一个信息占一行。
                格式为：张三-男-23
                要求通过程序实现随机点名器。

            运行效果：
                第一次运行程序：随机同学姓名1（只显示名字）
                第二次运行程序：随机同学姓名2（只显示名字）
                第三次运行程序：随机同学姓名3（只显示名字）
                …
         */
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\idea-WorkSpace\\IOStreamTeat\\names.txt"));
        ArrayList<String> students = new ArrayList<>();
        String stuinfo = "";
        while ((stuinfo = br.readLine()) != null) {
            students.add(stuinfo);
        }
        br.close();


        Random r = new Random();
        int index = r.nextInt(students.size());
        String name = students.get(index).split("-")[0];

        BufferedReader br2 = new BufferedReader(new FileReader("test2.txt"));
        int count = Integer.parseInt(br2.readLine());
        br2.close();
        count++;
        System.out.println("第" + count + "次点名:" + name);

        BufferedWriter bw = new BufferedWriter(new FileWriter("test2.txt"));
        bw.write(count + "");
        bw.close();

    }
}
