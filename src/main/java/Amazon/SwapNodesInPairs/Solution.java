package Amazon.SwapNodesInPairs;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode cur = dumy;
        while(cur.next!=null&&cur.next.next!=null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            second.next = first;
            cur = cur.next.next;
        }
        return dumy.next;
    }
}
