package Amazon.SortList;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMedian(head);
        ListNode right = sortList(mid);
        ListNode left = sortList(head);
        return merge(left, right);
    }
    ListNode findMedian(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=null ;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
    ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }
        return dummy.next;
    }
}
