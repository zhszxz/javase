package com.bistu.spring6iocxml.di;

public class Lesson {
    private String lname;

    public Lesson() {
    }

    public Lesson(String lname) {
        this.lname = lname;
    }

    /**
     * 获取
     *
     * @return lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * 设置
     *
     * @param lname
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    public String toString() {
        return "Lesson{lname = " + lname + "}";
    }
}
