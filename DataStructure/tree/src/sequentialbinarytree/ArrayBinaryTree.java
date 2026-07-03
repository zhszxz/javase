package sequentialbinarytree;

//顺序存储二叉树
//顺序二叉树一般只考虑满二叉树
//第n个元素左子节点为2n+1
//第n个元素右子节点为2n+2
//第n个元素父节点为（n-1）/2
//n为二叉树层序遍历的编号，从0开始，也就是二叉树结点在数组中的下标
public class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.preOrder(0);
    }

    //以二叉树前序遍历方式遍历存储二叉树结点的数组
    public void preOrder() {
        preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }
        System.out.println(arr[index]);
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}
