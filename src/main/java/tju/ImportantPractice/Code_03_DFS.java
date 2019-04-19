package tju.ImportantPractice;
import java.util.HashSet;
import java.util.Stack;
/*
* 深度优先遍历(它这个节点所有的路都走完了，才回到父)
* 图的深度优先搜索（Depth First Search）
* */
public class Code_03_DFS {
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();//栈
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {//遍历后代进去没进去过，这件事情，完成所有的路都走过，我才返回。
				if (!set.contains(next)) {//有新的岔路
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
}
