package com.bistu.Refelect1;

public class MyReflect1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
         * 获取class对象的三种方式：
         *   1. Class.forName("全类名");
         *   2. 类名.class
         *   3. 对象.getClass();
         *
         * */
        Class stu = Class.forName("com.bistu.Refelect1.Student");
        System.out.println(stu);


        System.out.println(Student.class);
        

        Student s1 = new Student();
        System.out.println(s1.getClass());
    }
}
