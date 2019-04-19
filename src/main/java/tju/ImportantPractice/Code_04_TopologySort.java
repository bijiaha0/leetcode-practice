package tju.ImportantPractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//拓扑排序、把工作安排好，先做哪个，后做哪个。解决依赖。
//1，拓扑排序算法 适用范围:要求有向图，且有入度为0的节点，且没有环。1、点只出现一次，2、后面节点没有到达前面节点的路。
public class Code_04_TopologySort {
	// directed graph and no loop 有向无环图
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();
		Queue<Node> zeroInQueue = new LinkedList<>();
		for (Node node : graph.nodes.values()) {//遍历所有的点
			inMap.put(node, node.in);//所有的点的入度登记到inMap里面
			if (node.in == 0) {
				zeroInQueue.add(node);//当前入度为0的点，进这个队列
			}
		}
		List<Node> result = new ArrayList<>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next) - 1);
				if (inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		return result;
	}
}
