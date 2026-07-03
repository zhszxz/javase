package com.bistu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test7 {
    public static void main(String[] args) throws IOException {
         /*
        需求：写一个登陆小案例。

        步骤：
            将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
            保存格式为:username=zhangsan&password=123
            让用户键盘录入用户名和密码
                    比较用户录入的和正确的用户名密码是否一致
            如果一致则打印登陆成功
                    如果不一致则打印登陆失败
        */
        BufferedReader br=new BufferedReader(new FileReader("D:\\Java\\idea-WorkSpace\\IOStreamTeat\\test7.txt"));
        String line= br.readLine();
        String[] split = line.split("&");
        String name=split[0].split("=")[1];
        String password = split[1].split("=")[1];

        Scanner sc=new Scanner(System.in);
        String inputname = sc.nextLine();
        String inputpassword = sc.nextLine();

        if(inputname.equals(name)&&inputpassword.equals(password)){
            System.out.println("登陆成功");
        }
        else{
            System.out.println("登录失败");
        }

    }
}
