package tju.ImportantPractice;
/*
* 图的生成
* */
public class GraphGenerator {
	public static Graph createGraph(Integer[][] matrix) {//矩阵里面的东西是weight、from、to
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			Integer weight = matrix[i][0];//的权重
			Integer from = matrix[i][1];//出
			Integer to = matrix[i][2];//入
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);//增加邻居节点
			fromNode.out++;//out指的是我指向多少节点
			toNode.in++;//in指的是有多少节点指向我
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);//整个图加Edge
		}
		return graph;
	}
}
