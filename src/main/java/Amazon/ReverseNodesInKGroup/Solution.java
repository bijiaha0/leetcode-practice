package Amazon.ReverseNodesInKGroup;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solutions/reverse-nodes-in-k-group/
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null) {
            head = reverseNextK(head, k);
        }

        return dummy.next;
    }
    // reverse head->n1->..->nk->next..
    // to head->nk->..->n1->next..
    // return n1
    private ListNode reverseNextK(ListNode head, int k) {
        // check there is enought nodes to reverse
        ListNode next = head; // next is not null
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;//返回
            }
            next = next.next;
        }
        // reverse
        ListNode n1 = head.next;
        ListNode prev = head, curt = n1;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        n1.next = curt;
        head.next = prev;
        return n1;
    }
}
