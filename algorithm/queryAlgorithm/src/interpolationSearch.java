import java.util.ArrayList;
import java.util.List;

//插值查找:相比二分查找只做了一个优化，每次从中间分割（1/2处）数组变成按插值公式计算分割点
public class interpolationSearch {
    public static void main(String[] args) {
        int[] arr = {25, 25, 25, 25, 25, 25, 25};
        List indexs = binarySearch(arr, 0, arr.length - 1, 25);
        System.out.println(indexs);
    }

    public static List<Integer> binarySearch(int[] arr, int start, int end, int target) {
        if (start > end || target < arr[0] || target > arr[arr.length - 1]) {
            return new ArrayList<>();
        }
        if (arr[start] == arr[end]) {//此时数组元素都相等
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(i);
            }
            return list;
        }
        if (start == end) {//此时子数组长度已经等于1
            if (arr[start] == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                return list;
            } else {
                return new ArrayList<>();
            }
        }

        int percentage = start + (end - start) * ((target - arr[start]) / (arr[end] - arr[start]));
        if (arr[percentage] == target) {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = percentage - 1;
            while (temp >= 0 && arr[temp] == target) {
                list.add(temp--);
            }
            list.add(percentage);
            temp = percentage + 1;
            while (temp <= arr.length - 1 && arr[temp] == target) {
                list.add(temp++);
            }
            return list;
        } else if (arr[percentage] > target) {
            return binarySearch(arr, start, percentage - 1, target);
        } else {
            return binarySearch(arr, percentage + 1, end, target);
        }
    }
}
