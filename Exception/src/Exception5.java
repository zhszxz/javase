public class Exception5 {
    public static void main(String[] args) {
        //异常中的常用方法
        int[] arr={1,2,3,4,5};
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();//最常用
        }
    }
}
