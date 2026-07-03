package com.bistu.MyTreeMap;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapDemo3 {
    public static void main(String[] args) {
        String str="abcdeabcdabcaba";
        TreeMap<Character,Integer> tm=new TreeMap<>();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(tm.containsKey(c)){
                Integer value = tm.get(c);
                value++;
                tm.put(c,value);
            }
            else{
                tm.put(c,1);
            }
        }
        StringBuilder sb=new StringBuilder();
        tm.forEach((key, value)->{sb.append(key).append("(").append(value).append(")");});
        System.out.println(sb);
    }
}
