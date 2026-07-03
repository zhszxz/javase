package com.bistu;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        /* 制造假数据：
             获取姓氏：https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0
             获取男生名字：http://www.haoming8.cn/baobao/10881.html
             获取女生名字：http://www.haoming8.cn/baobao/7641.html*/

        //1.爬取数据
        String familynameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boynameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlnameNet = "http://www.haoming8.cn/baobao/7641.html";

        String familyname = webCrawler(familynameNet);
        String boyname = webCrawler(boynameNet);
        String girlname = webCrawler(girlnameNet);

        //2.按照正则表达式提取数据
        ArrayList<String> FamilyNameList = getData(familyname, "(<div class=\"text\">)(.)(</div>)", 2);
        ArrayList<String> BoyNameTempList = getData(boyname, "([\\u4E00-\\u9FA5]{2})(、|。)", 1);
        ArrayList<String> GirlNameTempList = getData(girlname, "(.. ){4}..", 0);

        //3.处理数据
        //对男孩名字去重
        ArrayList<String> BoyNameList = new ArrayList<>();
        for (String bname : BoyNameTempList) {
            if (!BoyNameList.contains(bname)) {
                BoyNameList.add(bname);
            }
        }

        //对女孩名字分割
        ArrayList<String> GirlNameList = new ArrayList<>();
        for (String gnames : GirlNameTempList) {
            String[] split = gnames.split(" ");
            for (String gname : split) {
                GirlNameList.add(gname);
            }
        }

        //4.获取假姓名
        ArrayList<String> names = getNames(FamilyNameList, BoyNameList, GirlNameList, 50, 50);
        Collections.shuffle(names);

        //写出数据
        BufferedWriter bw=new BufferedWriter(new FileWriter("names.txt"));
        for (String name : names) {
            bw.write(name);
            bw.newLine();
        }
        bw.close();
    }

    private static ArrayList<String> getNames(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int boyCount, int girlCount) {

        Random r = new Random();
        //男生名不重复
        HashSet<String> bnames = new HashSet<>();
        while (bnames.size() <= boyCount) {
            bnames.add(familyNameList.get(0) + boyNameList.get(0) + "-" + "男" + "-" + (r.nextInt(6) + 15) + "岁");
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
        }

        //女生名不重复
        HashSet<String> gnames = new HashSet<>();
        while (gnames.size() <= girlCount) {
            gnames.add(familyNameList.get(0) + girlNameList.get(0) + "-" + "女" + "-" + (r.nextInt(6) + 15) + "岁");
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
        }

        ArrayList<String> names=new ArrayList<>();
        for (String bname : bnames) {
            names.add(bname);
        }

        for (String gname : gnames) {
            names.add(gname);
        }
        return names;
    }

    public static ArrayList<String> getData(String str, String regex, int index) {
        ArrayList<String> list = new ArrayList<>();
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(index);
            list.add(group);
        }
        return list;
    }

    private static String webCrawler(String net) throws URISyntaxException, IOException {
        URL url = new URL(net);
        URLConnection urlConnection = url.openConnection();
        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());

        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }

        return sb.toString();
    }


}
