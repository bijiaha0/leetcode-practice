package tju.ImportantPractice;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
/*
* 生成最小生成树的算法，应用范围是无向图。
* 一个点加入进来，解锁一些边，在所有的边里面，选一个没有使用的，权值最低的边。
* 然后继续解锁新的点，再把新的点的新的边加入进来（再解锁新的边）。
* */
// undirected graph only
public class Code_06_Prim {
	public static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}
	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		HashSet<Node> set = new HashSet<>();//从始至终只有一个set。
		Set<Edge> result = new HashSet<>();
		for (Node node : graph.nodes.values()) {//处理不连通，森林的问题。
			if (!set.contains(node)) {
				set.add(node);
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();
					Node toNode = edge.to;
					if (!set.contains(toNode)) {
						set.add(toNode);
						result.add(edge);
						for (Edge nextEdge : node.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
	}
}
