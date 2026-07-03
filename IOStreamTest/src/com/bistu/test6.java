package com.bistu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class test6 {
    public static void main(String[] args) throws IOException {
        // 带权重的随机抽取


        //读取学生信息
        ArrayList<Student> list = getStuInfo();

        //获取权重值
        double[] weight = getWeight(list);

        //计算权重占比, 分配权值区间
        double[] weightPercent = updateWeight(weight);

        for (int j = 0; j < 10; j++) {
            //随机抽取
            double random = Math.random();
            int i = 0;
            while (random > weightPercent[i]) {
                i++;
            }
            System.out.println(list.get(i).getName());

            //更新权值
            weight[i] = weight[i] / 2;

            weightPercent = updateWeight(weight);

        }

    }

    private static double[] updateWeight(double[] weight) {
        double weightCount = 0;
        for (double v : weight) {
            weightCount += v;
        }
        double[] weightPercent = new double[weight.length];
        for (int i = 0; i < weight.length; i++) {
            weightPercent[i] = weight[i] / weightCount;
        }
        for (int i = 1; i < weightPercent.length; i++) {
            weightPercent[i] = weightPercent[i] + weightPercent[i - 1];
        }
        return weightPercent;
    }

    private static double[] getWeight(ArrayList<Student> list) {
        double[] weight = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            weight[i] = list.get(i).getWeight();
        }
        return weight;
    }

    private static ArrayList<Student> getStuInfo() throws IOException {

        ArrayList<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\idea-WorkSpace\\IOStreamTeat\\test6.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("-");
            list.add(new Student(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3])));
        }
        return list;
    }
}
