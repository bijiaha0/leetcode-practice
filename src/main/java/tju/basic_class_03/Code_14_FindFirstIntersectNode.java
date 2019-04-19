package tju.basic_class_03;
import java.util.HashSet;

/*
1、求一个链表第一个入环节点：方式是快慢指针法，
     快指针两步，慢指针一步，
    *当快指针和慢指针相遇后，快指针回到开头，变成每次走一步。
    *如果列表有环的话，快慢指针会相遇
2、分别求h1的入环节点loop1和h2的入环节点loop2
      如果loop1等于null，loop2等于null，则是两个无环列表的想交问题。
      两个无环列表的相交问题怎么求？
      遍历h1，走到h1的最后一个节点以及统计它的长度
      遍历h2，走到h2的最后一个节点以及统计它的长度
      如果他们的最后一个节点不一样，那么一定不想交，返回null;
      如果他们的最后一个节点一样，那么一定想交，
      然后两个列表的长度做差，长度长的列表先走差值的长度步，然后两个列表一起走，他俩共同进入第一个入环节点。


       如果一个是有环列表(loop !=null)，一个是无环列表(loop = null)，则不可能相交。

       两个都有环的列表，判断loop1和loop2相等不相等，如果loop1和loop2相等，就等同于两个无环列表的相交问题。
       如果loop1和loop2不相等，
       从loop1往下走，回到自己都没有碰到loop2，则表示不相交。
       从loop1往下走，回到自己之前遇到了loop2，则表示相交，第一个相交的节点既可以是loop1也可以是loop2，你返回哪个都对。




两个单链表相交的一系列问题
【题目】 在本题中，单链表可能有环，也可能无环。
给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交。
请实现一个函数， 如果两个链表相交，请返回相交的第一个节点;
如果不相交，返回null 即可。 要求:如果链表1的长度为N，链表2的长度为M，
时间复杂度请达到 O(N+M)，额外空间复杂度请达到O(1)。

1、一个列表有环，而另外一个列表无环，那么他们不可能相交。(因为next的问题)
2、两个列表都无环，然后相交的问题
3、两个列表都有环，
 * */
public class Code_14_FindFirstIntersectNode {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		//无环列表相交问题
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		//两个都有环列表相交问题
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		//剩下的是一个有环，一个无环问题，他俩不可能相交，直接返回null。
		return null;
	}
    /*
    * 快指针两步，慢指针一步，
    * 当快指针和慢指针相遇后，快指针回到开头，变成每次走一步。
    *如果列表有环的话，快慢指针会相遇
    * */
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	/*
	* 两个无环列表相交的问题，返回第一次相交的位置
	* */
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;//两个列表的长度做差的绝对值
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;//判断谁长，谁短。
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while (n != 0) {//长的列表先走n步(n表示两个列表的长度差)
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
    //两个无环列表相交的问题，返回第一次相交的位置
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
    /*寻找第一次出现重复的******************经典解法
    * 返回第一个入环的节点
    * */
	public static Node getFirstLoopNode(Node head){
        HashSet<Node> set = new HashSet<>();//HashSet存放的是对象的内存地址
        while (head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
    }

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
