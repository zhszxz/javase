//堆排序
public class HeapSort {
    public static void main(String[] args) {
        /*int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));*/
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        arr = heapSort(arr);
        long end = System.currentTimeMillis();
        //7毫秒
        System.out.println("排序花费了：" + (end - start) + "毫秒");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] heapSort(int[] arr) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {//从最后一个非叶子节点开始循环调整大堆顶，循环结束后最大元素就在树的根节点（数组最左侧）
            adjustHeap(arr, i, arr.length);
        }
        /**
         *         9
         *        / \
         *       6   8
         *      / \
         *     5   4
         */
        int temp;
        for (int j = arr.length - 1; j > 0; j--) {//交换堆顶（数组最左侧）元素与最右侧元素
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);//缩小堆的范围继续调整
            /**第一次执行完这行代码：
             *       8
             *      / \
             *     6   4
             *    /
             *   5
             */
        }
        return arr;
    }

    /**
     * 调整以i为根节点的子树为大顶堆
     *
     * @param arr：待排序的数组，也就是顺序存储二叉树
     * @param i：待调整子树根节点在数组的下标
     * @param length：数组待调整部分的长度（开始为数组长度，之后每确定一个最大数就减1）
     * @return
     */
    public static int[] adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {//k循环去找i的左子节点
            if (k + 1 < length && arr[k + 1] > arr[k]) {//让k指向i子节点的较大者
                k++;
            }
            if (arr[k] > temp) {//如果子节点较大者大于arr[i]，进行调整
                arr[i] = arr[k];
                i = k;//让i指向子节点较大者，好进行下次调整，保证了循环开始时k始终指向i的左子节点
            } else {//如果子节点较大者不大于arr[i]，调整结束（因为调整是从下到上进行的，i的子节点下方早已调整过了）
                break;
            }
        }
        arr[i] = temp;
        /**此时以节点i为根的子树的最大值就作为子树的根
         *         4
         *        / \
         *       9   8
         *      / \
         *     5   6
         */
        return arr;
    }
}
