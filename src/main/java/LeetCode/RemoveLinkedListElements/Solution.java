package LeetCode.RemoveLinkedListElements;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Solution {
    public Node removeLinkedListElements(Node head, int val) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val==val) {
                cur.next =cur.next.next;
            } else {
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
