package com.bistu;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class test3 {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的信息，格式为：张三-男-23
            每一个学生信息占一行。
            要求通过程序实现随机点名器。
            70%的概率随机到男生
            30%的概率随机到女生
            随机100万次，统计结果。看生成男生和女生的比例是不是接近于7：3
        */
        //读取学生信息
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\idea-WorkSpace\\IOStreamTeat\\names.txt"));
        ArrayList<String> students = new ArrayList<>();
        String stuinfo = "";
        while ((stuinfo = br.readLine()) != null) {
            students.add(stuinfo);
        }
        br.close();

        //随机抽取学生
        Random r = new Random();
        double boyCount = 0;
        double girlCount = 0;
        for (int i = 1; i < 100; i++) {
            //7成抽取男生
            if (r.nextInt(10) < 7) {
                while (true) {
                    int index = r.nextInt(students.size());
                    String[] stu = students.get(index).split("-");
                    if (stu[1].equals("男")) {
                        System.out.println(stu[0]);
                        boyCount++;
                        break;
                    }
                }
            }
            //3成抽取女生
            else {
                while (true) {
                    int index = r.nextInt(students.size());
                    String[] stu = students.get(index).split("-");
                    if (stu[1].equals("女")) {
                        System.out.println(stu[0]);
                        girlCount++;
                        break;
                    }
                }
            }
        }
        System.out.println(boyCount / girlCount);

    }
}
