package tju.basic_class_04;
/*
在二叉树中找到一个节点的后继节点
【题目】
现在有一种新的二叉树节点类型如下:
        public class Node {
                public int value;
                public Node left;
                public Node right;
                public Node parent;
                public Node(int data) {
                        this.value = data;
} }

该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
假设有一 棵Node类型的节点组成的二叉树，
树中每个节点的parent指针都正确地指向自己的父节点，头节点的parent指向null。
只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。
在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。

整体遍历是先左后中后右的
对于一个节点，如果它的节点上有右子树，它的后继就是右子树上最左的节点。
对于一个节点，如果它的节点上没有右子树，但是它是它父亲的左孩子，则它的后继就是它的父亲。
对于一个节点，如果他的节点上没有右子树，查这个节点是哪个节点上左子树的最后一个节点。那么这个节点就是其父节点。
 * */
public class Code_07_DescendantNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getNextNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {//node有右子树
			return getLeftMost(node.right);//右子树上最左的节点就是后继
            //一个节点有右子树，则这个右子树的最左的节点就是后继
		} else {//没有右子树
			Node parent = node.parent;
			while (parent != null && parent.left != node) {//如果这个node是当前P的左孩子，则停
				node = parent;
				parent = node.parent;//如果你发现node是parent的右孩子就一路往上跳
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getNextNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getNextNode(test));
	}

}
