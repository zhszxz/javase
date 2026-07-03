package com.bistu.boot.pojo;

public class user {
    private long id;
    private String name;

    public user() {
    }

    public user(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 获取
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(long id) {
        this.id = id;
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

    public String toString() {
        return "user{id = " + id + ", name = " + name + "}";
    }
}
