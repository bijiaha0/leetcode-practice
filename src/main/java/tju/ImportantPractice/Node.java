package tju.ImportantPractice;
import java.util.ArrayList;
public class Node {
	public int value;
	public int in; //入度(有多少个节点指向我)
	public int out; //出度(我指向多少节点)
	public ArrayList<Node> nexts; //所有的邻居节点(我是from的条件下，我的邻居有多少)
	public ArrayList<Edge> edges; //所有的边的集合（form是我的条件下，出去的边有多少）
	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
