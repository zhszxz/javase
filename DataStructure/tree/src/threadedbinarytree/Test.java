package threadedbinarytree;

public class Test {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "kim");
        HeroNode node6 = new HeroNode(14, "lily");
        ThreadedBinaryTree tree = new ThreadedBinaryTree(node1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        tree.threadedBinaryTree(node1);
        HeroNode left = node6.left;
        HeroNode right = node6.right;
        System.out.println("前驱节点：" + left + "后继节点：" + right);
        //8,3,10,1,14,6
        tree.threadedList();
    }
}
