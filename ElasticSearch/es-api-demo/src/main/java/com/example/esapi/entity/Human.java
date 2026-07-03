package com.example.esapi.entity;

import lombok.Data;

import java.util.List;

@Data
public class Human {
    private String name;
    private int age;
    private int sex;
    private String desc;
    private List<String> tags;

    public Human() {
    }

    public Human(String name, int age, int sex, String desc, List<String> tags) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.desc = desc;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
