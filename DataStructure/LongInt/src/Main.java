import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LongInt num1 = new LongInt();
        num1.addLast(2);
        num1.addLast(7);
        num1.addLast(1);
        num1.addLast(8);
        num1.addLast(2);
        num1.addLast(8);
        num1.addLast(1);
        num1.addLast(8);
        num1.addLast(2);
        num1.addLast(8);
        LongInt num2 = new LongInt();
        num2.addLast(3);
        num2.addLast(1);
        num2.addLast(4);
        num2.addLast(1);
        num2.addLast(5);
        num2.addLast(9);
        num2.addLast(2);
        num2.addLast(6);
        num2.addLast(5);
        num2.addLast(3);
        LongInt addresult=new LongInt();
        addresult = addresult.add(num1, num2);
        LongInt subresult=new LongInt();
        subresult = subresult.subtract(num1, num2);
        System.out.println("相加结果为："+addresult);
        System.out.printf("相减结果为：");
        System.out.println((subresult.negative=false)?subresult:"-"+subresult);

    }
}