package threadedbinarytree;

public class HeroNode {
    int no;
    String name;
    HeroNode left;
    HeroNode right;
    int leftType;//0:指向左子树  1：指向前驱节点
    int rightType;//0：指向右子树  1：指向后继节点

    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String toString() {
        return "HeroNode{no = " + no + ", name = " + name + "}";
    }
}
