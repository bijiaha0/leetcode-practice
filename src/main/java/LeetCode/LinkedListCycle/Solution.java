package LeetCode.LinkedListCycle;
class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}
//判断链表内是否存在环
public class Solution {
    public boolean isCycle(Node head){
        if(head==null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
