package binarytree;

public class HeroNode {
    int no;
    String name;
    HeroNode left;
    HeroNode right;

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
