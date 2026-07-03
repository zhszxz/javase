import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class MyFunction2 {
    public static void main(String[] args) {
        //将list1中的String转为Integer
        ArrayList<String> list1=new ArrayList<>();
        Collections.addAll(list1,"1","2","3","4","5");
        /*list1.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).forEach(s-> System.out.println(s));*/

        //方法引用：静态方法
        list1.stream().map(Integer::parseInt).forEach(s-> System.out.println(s));
    }
}
