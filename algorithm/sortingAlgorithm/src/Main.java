public class Main {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
       sort(arr,new QuickSort());
        long end = System.currentTimeMillis();
        System.out.println("排序花费了：" + (end - start) + "毫秒");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] nums, Sort sort) {
        sort.sort(nums);
    }
}
