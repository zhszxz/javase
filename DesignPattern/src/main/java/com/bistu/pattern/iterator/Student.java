package com.bistu.pattern.iterator;

public class Student {
    private String name;
    private String num;

    public Student() {
    }

    public Student(String name, String num) {
        this.name = name;
        this.num = num;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return num
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
    }

    public String toString() {
        return "Student{name = " + name + ", num = " + num + "}";
    }
}
