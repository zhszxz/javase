import java.util.ArrayList;
import java.util.List;

//二分查找
public class  BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-13, 1, 23, 55, 78, 98, 198};
        List indexs = binarySearch(arr, 0, arr.length - 1, 1);
        System.out.println(indexs);
    }

    public static List<Integer> binarySearch(int[] arr, int start, int end, int target) {
        if (start > end || target < arr[0] || target > arr[arr.length - 1]) {
            return new ArrayList<>();
        }
        int mid = start + ((end - start) >> 1);
        if (arr[mid] == target) {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == target) {
                list.add(temp--);
            }
            list.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == target) {
                list.add(temp++);
            }
            return list;
        } else if (arr[mid] > target) {
            return binarySearch(arr, start, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, end, target);
        }
    }
}
