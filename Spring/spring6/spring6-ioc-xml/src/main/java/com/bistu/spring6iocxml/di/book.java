package com.bistu.spring6iocxml.di;

public class book {
    private String name;
    private String auhor;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public book() {
        System.out.println("无参构造被执行了。。。");
    }

    public book(String name, String auhor, double price) {
        System.out.println("有参构造被执行了。。。");
        this.name = name;
        this.auhor = auhor;
        this.price = price;
    }

    public static void main(String[] args) {
        book b1 = new book();
        b1.setName("java");
        b1.setAuhor("不到谁");
        book b2 = new book("c++", "c++之父",0);
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
     * @return auhor
     */
    public String getAuhor() {
        return auhor;
    }

    /**
     * 设置
     *
     * @param auhor
     */
    public void setAuhor(String auhor) {
        this.auhor = auhor;
    }

    public String toString() {
        return "book{name = " + name + ", auhor = " + auhor + "}";
    }
}
