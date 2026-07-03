package com.bistu.boot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "sheep")
public class sheep {
    private long id;
    private String name;
    private int age;

    public sheep() {
    }

    public sheep(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "pig{id = " + id + ", name = " + name + ", age = " + age + "}";
    }
}
