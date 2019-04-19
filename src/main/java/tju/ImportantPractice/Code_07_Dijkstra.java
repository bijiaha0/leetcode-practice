package tju.ImportantPractice;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
// no negative weight、权重不能为负数。
//有向图
//迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个节点到其他节点的最短路径。
//它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止。
public class Code_07_Dijkstra {
	public static HashMap<Node, Integer> dijkstra1(Node head) {
		HashMap<Node, Integer> distanceMap = new HashMap<>();//Node为到源头的某一个节点，Integer为该Node节点到源头的距离。
		distanceMap.put(head, 0);//源节点到自己的距离是0。
		HashSet<Node> selectedNodes = new HashSet<>();//已经选择过的Node。
		Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		while (minNode != null) {
			int distance = distanceMap.get(minNode);
			for (Edge edge : minNode.edges) {
				Node toNode = edge.to;
				if (!distanceMap.containsKey(toNode)) {
					distanceMap.put(toNode, distance + edge.weight);
				}
				distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
			}
			selectedNodes.add(minNode);
			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		}
		return distanceMap;
	}
	//选择一个最小距离的节点，但是不是已经选择过的。
	public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
		Node minNode = null;
		int minDistance = Integer.MAX_VALUE;
		for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
			Node node = entry.getKey();
			int distance = entry.getValue();
			if (!touchedNodes.contains(node) && distance < minDistance) {
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}
	//*******************************************************************************
	public static class NodeRecord {
		public Node node;
		public int distance;//目前Node到源节点的距离。
		public NodeRecord(Node node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}
	//订制堆，自己怎么改堆。
	public static class NodeHeap {
		private Node[] nodes;
		private HashMap<Node, Integer> heapIndexMap;//节点在堆上的距离
		private HashMap<Node, Integer> distanceMap;//节点到源点的距离
		private int size;//堆的大小
		public NodeHeap(int size) {
			nodes = new Node[size];
			heapIndexMap = new HashMap<>();
			distanceMap = new HashMap<>();
			this.size = 0;
		}
		public boolean isEmpty() {
			return size == 0;
		}
		public void addOrUpdateOrIgnore(Node node, int distance) {//有一个节点，目前为止，它到源点的距离是distance。请你调整这个堆。
			if (inHeap(node)) {//如果这个节点已经在堆上了，那么我更新它到源点的距离。
				distanceMap.put(node, Math.min(distanceMap.get(node), distance));
				insertHeapify(node, heapIndexMap.get(node));//距离变小了，往上冒。
			}
			if (!isEntered(node)) {//如果它从来没有进入过堆
				nodes[size] = node;
				heapIndexMap.put(node, size);
				distanceMap.put(node, distance);
				insertHeapify(node, size++);
			}//还有一个省略的过程，它不在堆上，它曾今进入过堆。
		}
		//关于这个节点到源节点的距离，已经定了，再也不改了。
		public NodeRecord pop() {
			NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
			swap(0, size - 1);
			heapIndexMap.put(nodes[size - 1], -1);
			distanceMap.remove(nodes[size - 1]);
			nodes[size - 1] = null;
			heapify(0, --size);//新加入到堆顶的节点，需要调整，往下沉。
			return nodeRecord;
		}
		private void insertHeapify(Node node, int index) {
			while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
				swap(index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}
		private void heapify(int index, int size) {
			int left = index * 2 + 1;
			while (left < size) {
				int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
						? left + 1 : left;
				smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
				if (smallest == index) {
					break;
				}
				swap(smallest, index);
				index = smallest;
				left = index * 2 + 1;
			}
		}
		//一个节点曾经进入过这个堆么
		private boolean isEntered(Node node) {
			return heapIndexMap.containsKey(node);
		}
		//一个节点目前在这个堆里边么
		private boolean inHeap(Node node) {
			return isEntered(node) && heapIndexMap.get(node) != -1;
		}
		//交换
		private void swap(int index1, int index2) {
			heapIndexMap.put(nodes[index1], index2);
			heapIndexMap.put(nodes[index2], index1);
			Node tmp = nodes[index1];
			nodes[index1] = nodes[index2];
			nodes[index2] = tmp;
		}
	}
	public static HashMap<Node, Integer> dijkstra2(Node head, int size) {//size是遍历一遍图以后，得到图的大小。
		NodeHeap nodeHeap = new NodeHeap(size);
		nodeHeap.addOrUpdateOrIgnore(head, 0);
		HashMap<Node, Integer> result = new HashMap<>();
		while (!nodeHeap.isEmpty()) {
			NodeRecord record = nodeHeap.pop();
			Node cur = record.node;
			int distance = record.distance;
			for (Edge edge : cur.edges) {
				nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
			}
			result.put(cur, distance);
		}
		return result;
	}
}
