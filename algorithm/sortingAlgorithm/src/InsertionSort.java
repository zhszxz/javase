//插入排序
//思想：将待排序数组的前一部分看作是一个有序表，后面的部分看作是一个无序表，每次从无序表取一个元素插入到有序表的合适位置
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        arr = insertionSort(arr);
        long end = System.currentTimeMillis();
        //2831毫秒
        System.out.println("排序花费了：" + (end - start) + "毫秒");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] insertionSort(int[] arr) {
        int startIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {//先找到无序表的起始索引
            if (arr[i + 1] < arr[i]) {
                startIndex = i + 1;
                break;
            }
        }
        for (int i = startIndex; i < arr.length; i++) {//依次将无序数组的每一个元素插入到有序数组的合适位置
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        return arr;
    }
}

