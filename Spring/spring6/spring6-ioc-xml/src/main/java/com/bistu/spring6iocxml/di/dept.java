package com.bistu.spring6iocxml.di;

import java.util.List;

public class dept {
    private String name;

    public List<emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<emp> empList) {
        this.empList = empList;
    }

    private List<emp> empList;

    public dept() {
    }

    public dept(String name, List<emp> list) {
        this.name = name;
        this.empList = list;
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

    public String toString() {
        return "dept{name = " + name + "}";
    }
}
