import java.util.List;

//二分查找非递归实现
public class BinarySearchNonRecursive {
    public static void main(String[] args) {
        int[] arr = {-13, 1, 23, 55, 78, 98, 198};
        int index = binarySearch(arr, 55);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (true) {
            if (start > end) {
                return -1;
            }
            int index = (start + end) / 2;
            if (arr[index] == target) {
                return index;
            } else if (arr[index] > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
    }
}
