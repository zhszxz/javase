package com.bistu.Mymap;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class mapDemo1 {
    public static void main(String[] args) {
        //map集合第一种遍历方式:通过键找值
        Map<String,String> map=new HashMap<>();
        map.put("abc","ABC");
        map.put("def","DEF");
        map.put("ghi","GHI");
        map.put("jkl","jkl");
        //keySet返回键的集合
        Set<String> key = map.keySet();
        //通过键找到值
        for (String s : key) {
            System.out.println("Key="+s+" "+"Value="+map.get(s));
        }

        Iterator<String> it = key.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(map.get(s));
        }

        key.forEach(s-> System.out.println("Key="+s+" "+"Value="+map.get(s)));


        //map集合的第二种遍历方式：先找键值对，再分别得到键和值
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+entry.getValue());
        }

        Iterator<Map.Entry<String, String>> it2 = entries.iterator();
        while(it2.hasNext()){
            Map.Entry<String, String> next = it2.next();
            System.out.println(next.getKey()+"="+next.getValue());
        }

        entries.forEach (Entry->System.out.println(Entry.getKey()+"="+Entry.getValue()));

        //map集合的第三种遍历方式：lambda表达式
        map.forEach((String s, String v)-> System.out.println(s+":"+v));
    }
}
