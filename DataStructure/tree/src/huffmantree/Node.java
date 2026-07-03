package huffmantree;

public class Node implements Comparable<Node> {
    Byte ch;
    Integer weight;
    Node left;
    Node right;


    public Node() {
    }

    public Node(Byte ch, int weight) {
        this.ch = ch;
        this.weight = weight;

    }

    public String toString() {
        if (ch == null) {
            return "Node{ch = " + "null" + ", weight = " + weight + "}";
        } else {
            return "Node{ch = " + (char) ch.byteValue() + ", weight = " + weight + "}";
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
