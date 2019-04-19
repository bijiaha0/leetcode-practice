package tju.ImportantPractice;
/*
* 生成最小生成树的算法，应用范围是无向图。
* 权重最小的边，加入进来，没形成环，就要它。
 * 如果加入进来，形成环了，就不要这条边。
 *
 * 从权值低的边，开始考虑，如果加入这个边，没有形成环，就要它；
 * 如果形成了环，就不要它。最终整个权重值是整体最低的。
 * 使用并查集)
* */
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//undirected graph only
public class Code_05_Kruskal {
	// Union-Find Set
	public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> rankMap;
		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}
		//是否是同一个集合
		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}
		//两个节点所在的集合合并
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}
	public static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
	}
	public static Set<Edge> kruskalMST(Graph graph) {
		UnionFind unionFind = new UnionFind();//先生成一个并查集
		unionFind.makeSets(graph.nodes.values());//把所有的点作为并查集中一个小的集合
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());//按照边的权重，组成一个小根堆。
		for (Edge edge : graph.edges) {
			priorityQueue.add(edge);//权重越小的边，往上边放。
		}
		Set<Edge> result = new HashSet<>();
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			if (!unionFind.isSameSet(edge.from, edge.to)) {
				result.add(edge);
				unionFind.union(edge.from, edge.to);
			}
		}
		return result;
	}
}
