package tju.basic_class_06;
/*
介绍一种时间复杂度O(N)，额外空间复杂度O(1)的二叉树的遍 历方式，N为二叉树的节点个数
Morris遍历
利用Morris遍历实现二叉树的先序，中序，后续遍历，时间复 杂度O(N)，额外空间复杂度O(1)。

什么morris遍历：对于任何一个有左子树的节点，两次回到自己；
							   对于没有左子树的节点，只到达这个节点一次。
* */
public class Code_01_MorrisTraversal {

	public static class Node {
		public int value;
		Node left;
		Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	//中序遍历
	public static void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;//当前节点
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {//如果cur1有左孩子
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;//如果我能往右穿，我就不停的往右穿。直到cur2变成cur1左子树上最右的节点。
				}
				if (cur2.right == null) {//如果cur2的右节点是指向null的
					cur2.right = cur1;//就让cur2的右孩子指向cur1
					cur1 = cur1.left;//然后cur1向左移动
					continue;//continue的是大while
				} else {//如果cur2的右节点是指向cur1的
					cur2.right = null;
				}
			}
			System.out.print(cur1.value + " ");
			cur1 = cur1.right;
		}
		System.out.println();
	}
	//先序遍历
	public static void morrisPre(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					System.out.print(cur1.value + " ");//第一次来到一个节点的时候，我打印它
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			} else {
				System.out.print(cur1.value + " ");//如果当前节点压根就没有左子树，那我也打印它。
			}
			cur1 = cur1.right;
		}
		System.out.println();
	}
	//后续遍历(打印时机，能够两次回到自己的节点，
	// 而且在第二次回到它的时候，逆序打印它左子树的右边界，
	// 最后单独逆序打印整棵树的右边界，就是后序遍历的结果)
	public static void morrisPos(Node head) {
		if (head == null) {
			return;
		}
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
					printEdge(cur1.left);//能够两次回到自己的节点，而且在第二次回到它的时候，逆序打印它左子树的右边界
				}
			}
			cur1 = cur1.right;
		}
		printEdge(head);//单独打印一下整棵树的右边界
		System.out.println();
	}

	public static void printEdge(Node head) {
		Node tail = reverseEdge(head);
		Node cur = tail;
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}

	public static Node reverseEdge(Node from) {
		Node pre = null;
		Node next = null;
		while (from != null) {
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}

	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		head.right.right = new Node(7);
		printTree(head);
		morrisIn(head);
		morrisPre(head);
		morrisPos(head);
		printTree(head);

	}

}
