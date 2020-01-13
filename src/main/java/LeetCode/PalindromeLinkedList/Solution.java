package LeetCode.PalindromeLinkedList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/discuss/181453/Java-or-2ms-or-O(n)-or-recursive-or-linked-list-as-a-queue-or-backtrack-or-easy-to-understand
 */
class Node {
    Node next;
    int val;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}

public class Solution {
    public boolean isOrNot = true;
    public boolean vaild(Node head) {
        helper(head, head);
        return isOrNot;
    }
    public Node helper(Node head, Node cur) {
        if (cur == null || !isOrNot) {
            return head;
        }
        head = helper(head, cur.next);
        if (head.val != cur.val) {
            isOrNot = false;
        }
        return head.next;
    }
    public static void main(String[] args) {
        Node header = new Node(1);
        header.next = new Node(2);
        header.next.next = new Node(3);
        header.next.next.next = new Node(3);
        header.next.next.next.next = new Node(2);
        header.next.next.next.next.next = new Node(1);
        boolean vaild = new Solution().vaild(header);
        System.out.println(vaild);
    }
}
