package zheng.linkedList;
/**
 * Author: bijiaha0
 * Date: 2018-12-06
 * Time: 10:56 PM
 * Email: clickgwas@gmail.com
 */
/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: Zheng
 */
public class LinkedListAlgo {
    // 单链表反转-----非递归版本
    public Node reverse(Node head) {
        Node pre=null,cur=head,next=null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    // 单链表反转-----递归版本
    public static Node reverseRec(Node head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        Node rHead = reverseRec(head.next);//去把你后面的小弟反转一下！
        head.next.next = head;
        head.next=null;
        return rHead;
    }
    // 链表中环的检测
    public static boolean checkCircle(Node list) {
        if (list == null) return false;
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }
    // 有序链表合并-----非递归版本
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;
        Node dummy = new Node(-1);
        Node r = dummy;
        while (la != null && lb != null) {
            if (la.data < lb.data) {
                r.next = la;
                la = la.next;
            } else {
                r.next = lb;
                lb = lb.next;
            }
            r = r.next;
        }
        if (la != null) {
            r.next = la;
        }
        if (lb != null) {
            r.next = lb;
        }
        return dummy.next;
    }

    // 有序链表合并-----递归版本
    public static Node mergeSortedListsRec(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;
        if(la.data< lb.data){
            la.next = mergeSortedListsRec(la.next, lb);
            return la;
        }else {
            lb.next = mergeSortedListsRec(lb.next, la);
            return lb;
        }
    }
    //删除倒数第K个结点
    //使用两个指针实现一次遍历，第一个指针先走k-1步，第二个指针一直不动；
    //然后两个指针同时移动，直到第一个指针遍历完成。
    //因为两个指针间隔为k-1，所以第二个指针指向的节点纪委倒数第k个节点。
    public static Node deleteLastKth(Node list, int k) {
        Node slow = list;
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {//先走k-1步
            fast = fast.next;
            i++;
        }
        if (fast == null) return list;
        Node prev = null;
        while (fast.next != null) {//快指针走到最后
            fast = fast.next;
            prev = slow;//记录倒数第k个节点的上一个位置
            slow = slow.next;
        }
        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }
    // 找中间位置的节点----> 快慢指针
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;
        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

}
