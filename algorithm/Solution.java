/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (queue.size() > 0) {
            ListNode minNode = queue.poll();
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
            cur.next = minNode;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}