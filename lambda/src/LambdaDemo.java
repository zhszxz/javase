import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        //使用Arrays的sort方法把数组按字符串长度排序
        String[] strs={"aaa","a","aaaa","aa"};
        //匿名内部类
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(Arrays.toString(strs));

        //Lambda表达式
        Arrays.sort(strs, (String o1, String o2)->{
                return o1.length()-o2.length();
            }
        );
        System.out.println(Arrays.toString(strs));

        //Lambda简写
        Arrays.sort(strs, (o1, o2)->o1.length()-o2.length());
        System.out.println(Arrays.toString(strs));
    }
}
