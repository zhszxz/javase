package com.bistu.MyTreeMap;

import java.util.TreeMap;

public class TreeMapDemo2 {
  public static void main(String[] args) {
    TreeMap<Student,String> tm=new TreeMap<>();
    tm.put(new Student("zhangsan",23),"福建");
    tm.put(new Student("lisi",24),"山东");
    tm.put(new Student("wangwu",25),"甘肃");
    tm.put(new Student("ale",23),"甘肃");
    tm.put(new Student("zhangsan",23),"甘肃");

    System.out.println(tm);
  }



}
