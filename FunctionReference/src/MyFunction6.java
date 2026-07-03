import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class MyFunction6 {
    public static void main(String[] args) {
        //方法引用：引用数组的构造方法
        //格式：数据类型[]::new
        //需求：将集合中的数据收集到数组当中
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);

       /* Integer[] arr = list.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });*/

        Integer[] arr = list.stream().toArray(Integer[]::new);

        System.out.println(Arrays.toString(arr));
    }
}
