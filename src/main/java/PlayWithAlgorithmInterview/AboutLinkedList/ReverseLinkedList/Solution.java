package PlayWithAlgorithmInterview.AboutLinkedList.ReverseLinkedList;

/*
*
*https://www.lintcode.com/problem/reverse-linked-list/description
* */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverse(ListNode head){
        //pre表示的是前继节点
        ListNode pre =null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
