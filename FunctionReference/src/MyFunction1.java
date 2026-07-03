import java.util.Arrays;
import java.util.Comparator;

public class MyFunction1 {
    public static void main(String[] args) {
        //利用sort方法降序排序数组
        Integer[] arr={1,2,3,4,5,6};
        //匿名内部类
        /*Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

    });
        System.out.println(Arrays.toString(arr));*/

        //lambda表达式
       /* Arrays.sort(arr, (Integer o1, Integer o2)->{return o2-o1;});
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, (o1, o2)-> o2-o1);
        System.out.println(Arrays.toString(arr));*/

        //方法引用
        //要求：
        //函数式接口才能使用方法引用
        //被引用方法需已经存在
        //被引用方法参数和返回值类型需与抽象方法一致
        //被引用方法须满足当前需求
        Arrays.sort(arr, MyFunction1::sub);
        System.out.println(Arrays.toString(arr));

    }

    private static int sub(Integer o1,Integer o2) {
        return o2-o1;
    }
}
