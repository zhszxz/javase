package com.bistu.spring6iocxml.di;

public class Teacher {
    private int tid;
    private String tname;

    public Teacher() {
    }

    public Teacher(int tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    /**
     * 获取
     * @return tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * 设置
     * @param tid
     */
    public void setTid(int tid) {
        this.tid = tid;
    }

    /**
     * 获取
     * @return tname
     */
    public String getTname() {
        return tname;
    }

    /**
     * 设置
     * @param tname
     */
    public void setTname(String tname) {
        this.tname = tname;
    }

    public String toString() {
        return "Teacher{tid = " + tid + ", tname = " + tname + "}";
    }
}
