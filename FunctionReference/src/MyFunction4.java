import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyFunction4 {
    public static void main(String[] args) {
         /*
        方法引用:
        引用构造方法  类名::new

        需求：
             集合里面存储姓名和年龄，要求封装成Student对象并收集到List集合中
       */

        //1.创建集合对象
        ArrayList<String> list=new ArrayList<>();
        //2.添加数据
        Collections.addAll(list, "张无忌,15", "周芷若,14", "赵敏,13", "张强,20", "张三丰,100", "张翠山,40", "张良,35", "王二麻子,37", "谢广坤,41");
        //3.将数据封装为对象
        /*List<Student> Students = list.stream().map(new Function<String, Student>() {
            @Override
            public Student apply(String s) {
                String[] split = s.split(",");
                return new Student(split[0], Integer.parseInt(split[1]));
            }
        }).collect(Collectors.toList());

        System.out.println(Students);*/
        //引用的方法型形参和返回值需与抽象方法一致，因此需要在Student中增加一个构造方法
        List<String> Students = list.stream().map(String::new).collect(Collectors.toList());
        System.out.println(Students);
    }
}
