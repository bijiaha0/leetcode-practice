package tju.ImportantPractice;
import java.util.HashMap;
import java.util.HashSet;
public class Graph {
	public HashMap<Integer,Node> nodes; //点的编号，实际对应点的node
	public HashSet<Edge> edges; //所有的边
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
