package binrysorttree;

public class Test {
    public static void main(String[] args) {
        BinrySortTree tree = new BinrySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        tree.delete(2);
        tree.delete(5);
        tree.delete(9);
        tree.delete(12);
        tree.delete(7);
        tree.delete(3);
        tree.delete(10);
        //tree.delete(1);
        tree.inOrder();
    }
}
