package PlayWithAlgorithmInterview.AboutLinkedList.RemoveNthNodeFromEndOfList;

/**
 * Author: bijiaha0
 * Date: 2018-12-05
 * Time: 11:01 AM
 * Email: clickgwas@gmail.com
 */

//查找链表的中点
public class FindMidNode {
    public static ListNode fidMid(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        ListNode listNode = fidMid(head);
        System.out.println(listNode.val);
    }



}
