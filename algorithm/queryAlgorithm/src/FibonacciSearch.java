import java.util.Arrays;
import java.util.HashSet;

//斐波那契查找:借助斐波那契数列确定分割点
//在斐波那契数列找第一个不小于数组长度的元素f(k)，作为新数组长度
//因为f(k)=f(k-1)+f(k-2)，数组长度等于f(K),可以分为:f(k-1)，f(k-2)两部分
//分割点索引就等于start+f(k-1)-1
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {-13, 1, 23, 55, 78, 98, 198};
        int index = fibonacciSearch(arr, 198);
        System.out.println(index);
    }

    public static int fibonacciSearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int[] fi = getFibonacciSequence(arr.length + 1);//得到斐波那契数列
        int k = 0;
        while ((end + 1) > fi[k]) {//找到第一个满足fi(k)>=数组长度的K
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fi[k]);
        for (int i = end + 1; i < temp.length; i++) {//fi(k)可能大于数组长度，将大于的部分全部置为arr[end]
            temp[i] = arr[end];
        }
        int mid;
        while (start <= end) {
            mid = start + fi[k - 1] - 1;//因为f(k)=f(k-1)+f(k-2)
            if (temp[mid] > target) {
                end = mid - 1;
                k -= 1;//因为左侧有f(k-1)个元素，可以继续分为：f(k-1)=f(k-2)+f(k-3)，下次mid=start+f(k-1-1)-1
            } else if (temp[mid] < target) {
                start = mid + 1;
                k -= 2;//因为右侧有f(k-2)个元素，可以继续分为：f(k-2)=f(k-3)+f(k-4)，下次mid=start+f(k-2-1)-1
            } else {
                return mid <= end ? mid : end;
            }
        }
        return -1;
    }

    public static int[] getFibonacciSequence(int length) {
        int[] sequence = new int[length];
        if (length <= 2) {
            for (int i = 0; i < sequence.length; i++) {
                sequence[i] = 1;
            }
        } else {
            sequence[0] = 1;
            sequence[1] = 1;
            for (int i = 2; i < length; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2];
            }
        }
        return sequence;
    }
}
