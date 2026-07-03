import java.util.*;
public class LongInt implements Comparable<LongInt>{
    // 定义链表节点
    private class Node {
        int val; // 节点的值

        Node prev; // 指向前一个节点的指针
        Node next; // 指向下一个节点的指针

        Node(int val) {
            this.val = val;
        }
    }

    private Node head; // 头节点
    private Node tail; // 尾节点
    private int size; // 链表长度
     boolean negative=false;// 标记结果是否为负数
    public LongInt() {
        head = null;
        tail = null;
        size = 0;
    }
    public LongInt(int[] a) {
        for(int i=0;i<a.length;i++){
            this.addLast(a[i]);
        }
    }
    // 从头部插入节点
    public void addFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // 从尾部插入节点
    public void addLast(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // 将链表转换为字符串表示形式
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }

    // 将两个长整数相加，返回一个新的长整数
    public LongInt add(LongInt num1, LongInt num2) {
        LongInt result = new LongInt();
        Node p = num1.tail;
        Node q = num2.tail;
        int carry = 0; // 进位
        while (p != null || q != null || carry != 0) {
            int sum = (p != null ? p.val : 0) + (q != null ? q.val : 0) + carry;
            result.addFirst(sum % 10);
            carry = sum / 10;
            if (p != null) p = p.prev;
            if (q != null) q = q.prev;
        }
        return result;
    }

    public LongInt subtract(LongInt num1, LongInt num2) {
        LongInt result = new LongInt();

        // 如果num2比num1大，将它们交换，并标记结果为负数
        if (num2.compareTo(num1) == 1) {
            LongInt temp = num1;
            num1 = num2;
            num2 = temp;
            result.negative = true;
        }

        // 将两个数的节点逐位相减，将结果存储在result中
        LongInt.Node p1 = num1.tail.prev, p2 = num2.tail.prev;
        int borrow = 0;
        while (p1 != num1.head) {
            int digit1 = p1.val;
            int digit2 = 0;
            if (p2 != num2.head) {
                digit2 = p2.val;
                p2 = p2.prev;
            }
            int diff = digit1 - digit2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.addFirst(diff);
            p1 = p1.prev;
        }

        // 根据结果的符号设置负号
        result.negative=this.negative;
        return result;
    }


    @Override
    public int compareTo(LongInt other) {
        if (this.negative && !other.negative) {
            return -1;
        } else if (!this.negative && other.negative) {
            return 1;
        } else if (this.size > other.size) {
            return this.negative ? -1 : 1;
        } else if (this.size < other.size) {
            return this.negative ? 1 : -1;
        } else {
            Node p1 = this.head.next, p2 = other.head.next;
            while (p1 != this.tail) {
                if (p1.val > p2.val) {
                    return this.negative ? -1 : 1;
                } else if (p1.val < p2.val) {
                    return this.negative ? 1 : -1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return 0;
        }
    }


}
