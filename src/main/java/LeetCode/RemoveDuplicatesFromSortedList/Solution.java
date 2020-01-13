package LeetCode.RemoveDuplicatesFromSortedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }else {
            head.next = deleteDuplicates(head.next);
            return head.val == head.next.val ? head.next : head;
        }
    }
}
