//基数排序：桶排序的扩展
//准备10个桶(数组)，下标为0到9
//第一轮：看待排序数组每个数的个位，是几就放到几号桶，然后再将桶中数据依次取出放回原数组，此时只看数组中数据的个位，已经是有序的
//第二轮：看待排序数组每个数的十位，重复上面的操作，第二轮结束后只看数组元素低两位，已经是有序的
//......
//排序轮数由数组最大数的位数决定
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        arr = radixSort(arr);
        long end = System.currentTimeMillis();
        //19毫秒
        System.out.println("排序花费了：" + (end - start) + "毫秒");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] radixSort(int[] arr) {
        int[][] buckets = new int[10][arr.length];//10个桶
        int[] elementCount = new int[10];//记录每个桶中有几个数据
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        int numberOfDigits = 0;//数组最大数的位数
        while (max > 0) {
            numberOfDigits++;
            max /= 10;
        }
        for (int k = 0; k < numberOfDigits; k++) {//排序轮数为最大数的位数
            for (int num : arr) {
                int digit = (int) (num / Math.pow(10, k)) % 10;//依次得到元素各个位
                buckets[digit][elementCount[digit]] = num;//将元素放在对应的桶中
                elementCount[digit]++;
            }
            int index = 0;
            for (int i = 0; i < buckets.length; i++) {//将桶中元素放回arr
                for (int j = 0; j < elementCount[i]; j++) {
                    arr[index] = buckets[i][j];
                    index++;
                }
                elementCount[i] = 0;//重置桶计数器
            }
        }
        return arr;
    }
}
