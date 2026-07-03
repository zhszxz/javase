package avltree;

public class Test {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        //int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 11, 7, 6, 8, 9};
        for (int i : arr) {
            tree.add(new TreeNode(i));
        }
        tree.inOrder();
        System.out.println("树高度：" + tree.getHeight(tree.root));
        System.out.println("根节点:"+tree.root);
        System.out.println("左子树高度：" + tree.getLeftHeight(tree.root));
        System.out.println("右子树高度：" + tree.getLeftHeight(tree.root));
    }
}
