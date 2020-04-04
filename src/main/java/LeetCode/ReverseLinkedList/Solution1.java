package LeetCode.ReverseLinkedList;
/**
 * id = 206
 * https://leetcode.com/problems/reverse-linked-list/
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class Solution1 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
