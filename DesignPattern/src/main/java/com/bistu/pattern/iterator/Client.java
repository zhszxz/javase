package com.bistu.pattern.iterator;

//迭代器模式
public class Client {
    public static void main(String[] args) {
        StudentAggregateImpl studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(new Student("zhangsan", "001"));
        studentAggregate.addStudent(new Student("lisi", "002"));
        studentAggregate.addStudent(new Student("wangwu", "003"));
        StudentIterator iterator = studentAggregate.getStudentIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
