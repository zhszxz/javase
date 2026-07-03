package com.bistu.spring6iocxml.di;

import java.util.Arrays;

//引用数据类型依赖注入
public class emp {
    private String name;
    private int age;
    private dept dept;

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    private String[] hobby;

    public emp() {
    }

    public emp(String name, int age, dept dept, String[] hobby) {
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.hobby = hobby;
    }
    public void work(){
        System.out.println("员工"+name+"("+age+"岁）正在工作,部门："+ dept.getName());
        System.out.println(Arrays.toString(hobby));
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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return dept
     */
    public dept getDept() {
        return dept;
    }

    /**
     * 设置
     * @param dept
     */
    public void setDept(dept dept) {
        this.dept = dept;
    }

    public String toString() {
        return "emp{name = " + name + ", age = " + age + ", dept = " + dept + "}";
    }
}
