package binarytree;

public class Test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new HeroNode(1, "宋江");
        tree.root.left = new HeroNode(2, "吴用");
        tree.root.right = new HeroNode(3, "卢俊义");
       // tree.root.right.left = new HeroNode(5, "关胜");
        tree.root.right.right = new HeroNode(4, "林冲");
        System.out.println("前序遍历,删除前：");
        tree.preOrder();
        /*System.out.println("中序遍历：");
        tree.inOrder();
        System.out.println("后序遍历：");
        tree.postOrder();*/
       /* System.out.println("前序查找：");
        System.out.println(tree.preOrderSearch(6));
        System.out.println("中序查找：");
        System.out.println(tree.inOrderSearch(6));
        System.out.println("后序查找：");
        System.out.println(tree.postOrderSearch(1));*/
        tree.delete(3);
        System.out.println("前序遍历,删除后：");
        tree.preOrder();
    }
}
