package tju.ImportantPractice;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/*
* 宽度优先遍历(广度优先遍历)
* 广度优先遍历（Breadth First Search）,又称为宽度优先遍历或者横向优先搜索，简称BFS。
* 准备一个队列，从头节点开始，先放进入，
* 每次弹出一个节点，先加左，再加右。出队列的顺序就是宽度的顺序。
* */
public class Code_02_BFS {
	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();//队列
		HashSet<Node> map = new HashSet<>();//表示所有进过队列的节点
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}
}
