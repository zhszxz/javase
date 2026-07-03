import java.util.Arrays;

public class Expection6 {
    public static void main(String[] args) {
        /*
        throws：写在方法定义处，表示声明一个异常。告诉调用者，使用本方法可能会有哪些异常,如果是编译时异常，必须写，如果是运行时异常，则可省略不写
        throw ：写在方法内，结束方法。手动抛出异常对象，交给调用者。方法中下面的代码不再执行了。

        需求：
            定义一个方法求数组的最大值
*/

        int[] arr={1,2,3,4,5,6};
        //int[] arr=null;
        //int[] arr={};
        try {
            int max = max(arr);
            System.out.println(max);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
    public static int max(int[] arr) throws NullPointerException,ArrayIndexOutOfBoundsException{
        if(arr==null){
            throw new NullPointerException();
        }
        if(arr.length==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int max=0;
        for (int i : arr) {
            if(i>max)
                max=i;
        }
        return max;
    }
}
