package threadedbinarytree;

//中序线索化二叉树
public class ThreadedBinaryTree {
    HeroNode root;
    HeroNode pre;//指向中序遍历当前节点的前一个节点

    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
    }

    //中序线索化二叉树
    public void threadedBinaryTree(HeroNode node) {
        if (node == null) {
            return;
        }
        //先处理左子树
        threadedBinaryTree(node.left);
        //再处理当前节点
        //①让当前节点的left指向前驱节点
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        //②让当前节点的right指向后继节点（在下一次递归时完成）
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        //③pre指向下一个节点
        pre = node;
        //最后处理右子树
        threadedBinaryTree(node.right);
    }

    //遍历中序线索二叉树
    public void threadedList() {
        HeroNode node = root;
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

}
