import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;

public class MyFunction3 {
    public static void main(String[] args) {
        //方法引用：
        // 其他类的成员方法 对象::方法名
        // 本类的成员方法   this::方法名（引用出不能是静态的）
        // 父类的成员方法   super::方法名（引用出不能是静态的）
        //需求：过滤数据，留下以张开头，长度为三的数据
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"张无忌","张三丰","周芷若","张强","赵敏");

        /*list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        }).filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()==3;
            }
        }).forEach(s-> System.out.println(s));*/

       // list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(s-> System.out.println(s));

        //引用其他类的成员方法
        list.stream().filter(new StringOperation()::StringJudge).forEach(s-> System.out.println(s));
    }
}
