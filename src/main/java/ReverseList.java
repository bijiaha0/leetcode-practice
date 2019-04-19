/**
 * Author: bijiaha0
 * Date: 2019-02-17
 * Time: 2:09 PM
 * Email: clickgwas@gmail.com
 */
//反转链表---非递归
class Node{
    Node next;
    int val;
    public Node(int val){
        this.val = val;
    }
}
public class ReverseList {
    public Node reverse(Node head){
        Node next = null;
        Node pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            //head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
