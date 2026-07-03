package com.bistu.Mymap;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.BiConsumer;

public class mapDemo3 {
    //组织投票，80人每人在A，B，C,D四个景点选择一个，最后统计哪个景点想去的人最多
    public static void main(String[] args) {
        HashMap<Character,Integer> hm=new HashMap<>();
        Random r=new Random();
        for (int i = 0; i < 80; i++) {
            int num = r.nextInt(4)+1;
            switch (num){
                case 1: {
                if(hm.containsKey('A')){
                    int count=hm.get('A')+1;
                    hm.put('A',count);
                }
                else hm.put('A',1);
                    break;}
                case 2:{
                    if(hm.containsKey('B')){
                        int count=hm.get('B')+1;
                        hm.put('B',count);
                    }
                    else hm.put('B',1);
                    break;}
                case 3:{
                    if(hm.containsKey('C')){
                    int count=hm.get('C')+1;
                    hm.put('C',count);
                }
                else hm.put('C',1);
                    break;}
                case 4:{
                    if(hm.containsKey('D')){
                    int count=hm.get('D')+1;
                    hm.put('D',count);
                }
                else hm.put('D',1);
                    break;}

                default:
                    System.out.println("没有这个选项");
            }
        }

        int max=0;
        char name=' ';
        Set<Map.Entry<Character, Integer>> entries = hm.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = entries.iterator();
        while (it.hasNext()){
            Map.Entry<Character, Integer> next = it.next();
            System.out.println(next);
            if ((next.getValue()>max)){
                max= next.getValue();
                name=next.getKey();
            }
        }
        System.out.println("得票最高的景点是："+name+", "+"票数为："+max);

    }
}
