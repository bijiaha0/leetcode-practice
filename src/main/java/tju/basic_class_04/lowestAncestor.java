package tju.basic_class_04;
/**
 * Author: bijiaha0
 * Date: 2018-10-30
 * Time: 下午8:37
 * Email: clickgwas@gmail.com
 */
public class lowestAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
    public Node findLowestAncestor(Node head,Node o1,Node o2){
        if(head==null||head == o1 ||head ==o2){
            return head;
        }
        Node left = findLowestAncestor(head.left,o1,o2);
        Node right = findLowestAncestor(head.right,o1,o2);
        if(left!=null && right!=null){
            return head;
        }
        return left!=null ? left:right;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        Node lowestAncestor = new lowestAncestor().findLowestAncestor(head, head.right.left, head.right.right.left);
        int value = lowestAncestor.value;
        System.out.println(value);
    }
}
