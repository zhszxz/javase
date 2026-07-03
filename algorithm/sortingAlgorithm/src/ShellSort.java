//希尔排序
//思想：先选择一个步长gap(初始为数组长的的一半),每轮排序将数组元素分为gap组，组中个元素间隔为gap
//然后比较每组元素中的相邻元素（组中相邻元素是指间隔为gap），使小的在左，大的在右（不同组的排序是同时进行的）
//完成后gap减半进行下一轮,gap等于1为最后一轮
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        arr = shellSort(arr);
        long end = System.currentTimeMillis();
        //4846毫秒
        System.out.println("排序花费了：" + (end - start) + "毫秒");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {//控制排序共进行几轮
            for (int i = gap; i < arr.length; i++) {//单轮排序中，同时排序各个组的相邻元素,所有的组共有几个相邻元素对，循环就进行几次
                for (int j = i - gap; j >= 0; j -= gap) {//组内排序：比较arr[j]与arr[j+gap],然后j=j-gap继续比较组内下一对相邻元素
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

   /* public static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j-gap]>arr[j]) {
                    while (j - gap >= 0 && arr[j - gap] > arr[j]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }*/
}
