package LeetCode.ReverseLinkedList;
// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
// 递归的方式反转链表
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //非尾递归【先解决下一层，再解决当前层】
    public ListNode reverseList(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    //尾递归【先解决当前层，再解决下一层】
    public ListNode reverseList1(ListNode head) {
        return reverseListHelper(head, null);
    }
    private ListNode reverseListHelper(ListNode head, ListNode newHead) {
        if (head == null){
            return newHead;
        }
        //传递下一层
        ListNode next = head.next;
        //解决当前层的问题
        head.next = newHead;
        return reverseListHelper(next, head);
    }
}
