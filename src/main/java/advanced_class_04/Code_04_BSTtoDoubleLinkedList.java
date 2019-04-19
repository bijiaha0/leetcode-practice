package advanced_class_04;
import java.util.LinkedList;
import java.util.Queue;
//树转双向列表
public class Code_04_BSTtoDoubleLinkedList {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node convert1(Node head) {
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		head = queue.poll();
		Node pre = head;
		pre.left = null;
		Node cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	public static void inOrderToQueue(Node head, Queue<Node> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}

	public static Node convert2(Node head) {
		if (head == null) {
			return null;
		}
		Node last = process(head);
		head = last.right;
		last.right = null;
		return head;
	}

	public static Node process(Node head) {
		if (head == null) {
			return null;
		}
		Node leftE = process(head.left); // left end
		Node rightE = process(head.right); // right end
		Node leftS = leftE != null ? leftE.right : null; // left start
		Node rightS = rightE != null ? rightE.right : null; // right start
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}
	}

	public static void printBSTInOrder(Node head) {
		System.out.print("BST in-order: ");
		if (head != null) {
			inOrderPrint(head);
		}
		System.out.println();
	}

	public static void inOrderPrint(Node head) {
		if (head == null) {
			return;
		}
		inOrderPrint(head.left);
		System.out.print(head.value + " ");
		inOrderPrint(head.right);
	}

	public static void printDoubleLinkedList(Node head) {
		System.out.print("Double Linked List: ");
		Node end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.right;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.left;
		}
		System.out.println();
	}
	
	
	
	
	public static Node getSortedDoubleList(Node head) {
		if(head == null) {
			return null;
		}
		return convert(head).head;
	}
	//todo--------
	public static class ReturnType{
		public Node head;
		public Node tail;
		public ReturnType(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}
	
	public static ReturnType convert(Node X) {
		if(X == null) {
			return new ReturnType(null, null);
		}
		ReturnType leftList = convert(X.left);
		ReturnType rightList = convert(X.right);
		if(leftList.tail !=null) {
			leftList.tail.right = X;
		}
		X.left = leftList.tail;
		X.right = rightList.head;
		if(rightList.head!=null) {
			rightList.head.left = X;
		}
		return new ReturnType( 
				leftList.head!=null ?   leftList.head : X, 
						rightList.tail!=null ? rightList.tail:X);
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(2);
		head.right = new Node(9);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.right.right = new Node(4);
		head.right.left = new Node(7);
		head.right.right = new Node(10);
		head.left.left = new Node(1);
		head.right.left.left = new Node(6);
		head.right.left.right = new Node(8);

		printBSTInOrder(head);
		head = convert1(head);
		printDoubleLinkedList(head);

		head = new Node(5);
		head.left = new Node(2);
		head.right = new Node(9);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.right.right = new Node(4);
		head.right.left = new Node(7);
		head.right.right = new Node(10);
		head.left.left = new Node(1);
		head.right.left.left = new Node(6);
		head.right.left.right = new Node(8);

		printBSTInOrder(head);
		head = convert2(head);
		printDoubleLinkedList(head);

	}

}