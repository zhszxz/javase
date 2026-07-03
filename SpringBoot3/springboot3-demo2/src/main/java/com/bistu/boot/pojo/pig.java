package com.bistu.boot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//将配置文件里以指定前缀开头的配置项按属性名进行绑定
//必选首先将类标记为spring容器的组件
//@ConfigurationProperties(prefix = "pig")
public class pig {
    private long id;
    private String name;
    private int age;

    public pig() {
    }

    public pig(long id, String name, int age) {
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
