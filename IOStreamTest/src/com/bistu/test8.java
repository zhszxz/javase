package com.bistu;

import java.io.*;
import java.util.Scanner;

public class test8 {
    public static void main(String[] args) throws IOException {
        /*
        需求：写一个登陆小案例（添加锁定账号功能）

        步骤：
        	将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        	保存格式为:1
        	让用户键盘录入用户名和密码
        	比较用户录入的和正确的用户名密码是否一致
        	如果一致则打印登陆成功
        	如果不一致则打印登陆失败，连续输错三次被锁定

        */
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\idea-WorkSpace\\IOStreamTeat\\test7.txt"));
        String line = br.readLine();
        br.close();

        String[] split = line.split("&");

        int count = Integer.parseInt(split[2].split("=")[1]);
        if (count==3) {
            System.out.println("账号被锁定！");
            System.exit(0);
        }

        String name = split[0].split("=")[1];
        String password = split[1].split("=")[1];

        Scanner sc = new Scanner(System.in);
        String inputname = sc.nextLine();
        String inputpassword = sc.nextLine();

        if (inputname.equals(name) && inputpassword.equals(password)) {
            System.out.println("登陆成功");
            count=0;
        } else {
            System.out.println("登录失败");
            count++;
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\Java\\idea-WorkSpace\\IOStreamTeat\\test7.txt"));
        StringBuilder sb=new StringBuilder();
        sb.append(line.substring(0,line.length()-1));
        sb.append(count+"");
        bw.write(sb.toString());
        bw.close();

    }
}
