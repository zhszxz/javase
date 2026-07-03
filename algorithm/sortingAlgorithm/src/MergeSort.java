//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        arr = mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        long end = System.currentTimeMillis();
        //9毫秒
        System.out.println("排序花费了：" + (end - start) + "毫秒");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {//left=right时数组被分为一个元素一组，此时递归返回开始归并
            int mid = (left + right) / 2;//每次递归调用将数组分为两个子数组
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            arr = merge(arr, left, mid, right, temp);//归并两个有序子数组
        }
        return arr;
    }

    private static int[] merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            temp[index++] = (arr[leftIndex] < arr[rightIndex]) ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (rightIndex <= right) {
            temp[index++] = arr[rightIndex++];
        }

        while (leftIndex <= mid) {
            temp[index++] = arr[leftIndex++];
        }

        for (int i = 0; i < index; i++) {
            arr[left + i] = temp[i];
        }
        return arr;
    }
}
