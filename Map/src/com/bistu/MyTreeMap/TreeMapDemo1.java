package com.bistu.MyTreeMap;

import java.util.TreeMap;

public class TreeMapDemo1 {
    public static void main(String[] args) {
        //降序排列
        TreeMap<Integer,String> tm=new TreeMap<>((Integer o1, Integer o2)->o2-o1);
        tm.put(003,"奥利奥");
        tm.put(004,"农夫山泉");
        tm.put(001,"脉动");
        tm.put(002,"康师傅");
        System.out.println(tm);
    }
}
