import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr1=new int[10];
        Random r=new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=r.nextInt(11);
        }
        //sort使用快速排序
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        Integer[] arr2=new Integer[10];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i]=r.nextInt(11);
        }
        //重载sort按指定规则排序，arr2必须为引用数据类型，另外传入一个Comparator接口实现类的对象，这里采用匿名内部类
        //o1-o2为升序，o2-o1为降序
        Arrays.sort(arr2,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(arr2));

        //使用Lambda表达式简化匿名内部类,只有函数式接口可以用Lambda表达式简化
        Arrays.sort(arr2,(Integer o1, Integer o2)->{
                return o1-o2;
            }
        );
        System.out.println(Arrays.toString(arr2));

        //简写Lambda表达式（参数类型不写，若参数只有一个，小括号不写，若函数体只有一行，大括号，分号，return同时不写
        Arrays.sort(arr2,(o1, o2)-> o1-o2);
        System.out.println(Arrays.toString(arr2));
    }
}