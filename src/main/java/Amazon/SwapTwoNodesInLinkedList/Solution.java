package Amazon.SwapTwoNodesInLinkedList;

/**
 * Author: bijiaha0
 * Date: 2019-03-04
 * Time: 00:00
 * Email: clickgwas@gmail.com
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node1Prev = null, node2Prev = null;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            } else if (cur.next.val == v2) {
                node2Prev = cur;
            }
            cur = cur.next;
        }

        if (node1Prev == null || node2Prev == null) {
            return head;
        }

        if (node2Prev.next == node1Prev) {
            // make sure node2Prev.next is not node1Prev
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }

        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;

            node2Prev.next = node1;
            node1.next = node2Next;
        }

        return dummy.next;
    }
}
