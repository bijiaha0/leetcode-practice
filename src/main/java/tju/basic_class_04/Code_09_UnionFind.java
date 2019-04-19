package tju.basic_class_04;
import java.util.HashMap;
import java.util.List;
//认识并查集
public class Code_09_UnionFind {
	public static class Node {
		// whatever you like
	}
	public static class DisjointSets {
		//(key,value)表示，key的父节点，是value,(Data_A , Data_B)代表，Data_A的父节点是Data_B
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> rankMap;

		public DisjointSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
			makeSets(nodes);//将所有的节点初始化操作
		}

		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}
		/*找代表*/
		public Node findDaiBiao(Node node) {
			Node father = fatherMap.get(node);//得到node的父亲
			if (father != node) {//当前的father不等于node就执行，当前的father等于node就不执行。
				father = findDaiBiao(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		public boolean isSameSet(Node a, Node b){//查找是否是同一个集合
			return findDaiBiao(a)==findDaiBiao(b);//父节点是否相等
		}

		public void union(Node a, Node b) {//合并
			if (a == null || b == null) {
				return;
			}
			Node aFather = findDaiBiao(a);
			Node bFather = findDaiBiao(b);
			if (aFather != bFather) {//说明a、b不是同一个集合
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);//小的挂在大的节点下边。
					rankMap.put(bFather, aFrank + bFrank);//代表节点、大小尺寸
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}
	public static void main(String[] args) {
	}

}
