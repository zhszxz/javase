//带头结点的单链表模拟栈
public class Stack {
    private Node head = new Node();//头节点，next指向栈顶

    private class Node {
        int value;
        Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(int val) {//头插法
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空!");
        }
        int value = head.next.value;
        head.next = head.next.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空!");
        }
        return head.next.value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空!");
        }
        Node cur = head.next;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}