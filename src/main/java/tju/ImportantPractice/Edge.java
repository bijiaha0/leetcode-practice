package tju.ImportantPractice;
public class Edge {
	public int weight;//这个边的权重是多少
	public Node from;//这个边的form节点是啥
	public Node to;//这个边的to节点是啥
	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}
}
