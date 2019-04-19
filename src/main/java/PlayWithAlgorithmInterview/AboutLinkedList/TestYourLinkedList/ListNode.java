package PlayWithAlgorithmInterview.AboutLinkedList.TestYourLinkedList;
// Definition for singly-linked list.
// 在Java版本中，我们将LinkedList相关的测试辅助函数写在ListNode里
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int x) {
        val = x;
    }
    // 根据n个元素的数组arr创建一个链表
    // 使用arr为参数，创建另外一个ListNode的构造函数
    public ListNode (int[] arr){
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");
        this.val = arr[0];
        //在函数中，需要引用该函数所属类的当前对象时候，直接使用this
        ListNode curNode = this;
        for(int i = 1 ; i < arr.length ; i ++){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }
    //根据n个元素的数组arr创建一个链表, 并返回链表的头
    public ListNode getListNode(int[] arr){
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i != arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
    // 返回以当前ListNode为头结点的链表信息字符串
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("");
        //this表示当前对象，在函数中，需要引用该函数所属类的当前对象时候，直接使用this
        ListNode curNode = this;
        while(curNode != null){
            s.append(Integer.toString(curNode.val));
            s.append(" -> ");
            curNode = curNode.next;
        }
        s.append("NULL");
        return s.toString();
    }
}