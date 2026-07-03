package com.bistu.Mymap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class mapDemo2 {
    public static void main(String[] args) {
        HashMap<Student,String> map=new HashMap<>();
        map.put(new Student("zhangsan",23),"<越南");
        map.put(new Student("lisi",24),"毛里求斯");
        map.put(new Student("wangwu",25),"密西西比");
        map.put(new Student("zhangsan",23),"图瓦卢");

        map.forEach((Student student, String s)-> System.out.println(student+" "+s));

        Set<Student> students = map.keySet();
        for (Student student : students) {
            System.out.println(student+map.get(student));
        }

        Set<Map.Entry<Student, String>> entries = map.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            System.out.println(entry);
        }
    }
}
