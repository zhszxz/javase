//快速排序
//原理：选择一个基准数，双指针分别从左边找大于基准数的数、从右边找小于基准数的数，找到就交换直到指针相遇
//此时双指针的位置就是基准数该在的位置，左边的数全部小于基准数，右边全部大于基准数
//对左右两个子数组进行递归，子数组长度会随递归减小，长度为1时递归结束
public class QuickSort implements Sort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int baseNum = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= baseNum) {
                swap(nums, j, i++);
            }
        }
        swap(nums, i, right);
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }

    public void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
