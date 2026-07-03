//选择排序
//原理：第一轮从arr[0]到arr[length-1]选择最小元素，与arr[0]交换
//第二轮从arr[1]到arr[length-1]选择最小元素，与arr[1]交换
//......
//核心思想：每轮确定一个最小元素，使其在数组最左边
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        arr = selectionSort(arr);
        long end = System.currentTimeMillis();
        //1658毫秒
        System.out.println("排序花费了：" + (end - start) + "毫秒");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] selectionSort(int[] arr) {
        int min;
        int index;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];//先假设当前元素就是最小的
            index = i;
            for (int j = i + 1; j < arr.length; j++) {//向右查找有无更小元素，记录其值和下标
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (i != index) {
                int temp = arr[i];//交换当前元素与最小值
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return arr;
    }

    //第二种写法
    /*public static int[] selectionSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }*/
}
