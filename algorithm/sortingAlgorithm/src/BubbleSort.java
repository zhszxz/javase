//冒泡排序
//原理：在一趟排序中依次比较相邻元素，使较大元素在右边
//第一趟排序结束后，最大元素就在数组最右边
//第二趟排序结束后，次大元素就在数组次右边
//......
//核心思想：每轮确定一个最大元素，使其在数组最右边
public class BubbleSort implements Sort {
    public void sort(int[] nums) {
        boolean flag = false;//标志一趟排序中有没有交换元素
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {//若一趟排序中没有交换任何元素，则数组已经是有序的
                break;
            } else {
                flag = false;
            }
        }
    }
}
