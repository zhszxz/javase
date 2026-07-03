//约瑟夫问题：有n个小孩坐成一圈，从第m个小孩开始报数，报到k的孩子出列，然后下一个小孩重新从1开始报数，问出列顺序
public class JosephProblem {
    public static void main(String[] args) {
        JosephProblem list = new JosephProblem();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        list.list();
        list.start(3, 4);
    }

    private Node first;//第一个小孩
    private Node cur;

    private class Node {
        int no;
        Node next;

        public Node() {
        }

        public Node(int no) {
            this.no = no;
        }
    }

    public void add(int no) {
        if (first == null) {//第一次添加
            first = new Node(no);
            cur = first;
            first.next = first;
            return;
        }
        Node node = new Node(no);
        cur.next = node;
        node.next = first;
        cur = cur.next;
    }

    public void list() {
        cur = first;
        do {
            System.out.print(cur.no + " ");
            cur = cur.next;
        } while (cur != first);
        System.out.println();
    }

    public void start(int begin, int num) {
        //begin：从第begin个小孩开始报数的
        //num：报到num的小孩出列
        cur = first;
        while (cur.next != first) {//先让cur指向最后一个小孩
            cur = cur.next;
        }
        for (int i = 0; i < begin - 1; i++) {//找到开始报数的小孩（first）和前一个小孩（cur）
            cur = cur.next;
            first = first.next;
        }
        while (true) {
            if (cur == first) {//只剩一个小孩
                System.out.println("存活到最后的是：" + first.no);
                break;
            }
            for (int i = 0; i < num - 1; i++) {//开始报数，结束后first指向待出圈的小孩，cur指向前一个小孩
                cur = cur.next;
                first = first.next;
            }
            System.out.println("小孩" + first.no + "出圈");
            first = first.next;
            cur.next = first;
        }
    }
}
