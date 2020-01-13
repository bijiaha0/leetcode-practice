package LeetCode.CloneGraph;
import java.util.*;
/**
 * 克隆图
 */
class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        UndirectedGraphNode that = (UndirectedGraphNode) o;
        return label == that.label &&
                Objects.equals(neighbors, that.neighbors);
    }
    @Override
    public int hashCode() {
        return Objects.hash(label, neighbors);
    }
}
//BFSAndDFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        return BFSHelper(node);
    }
    private UndirectedGraphNode BFSHelper(UndirectedGraphNode node) {
        Deque<UndirectedGraphNode> deque = new ArrayDeque<>();
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        deque.addLast(node);
        map.put(node,new UndirectedGraphNode(node.label));
        while (!deque.isEmpty()){
            UndirectedGraphNode cur = deque.pollLast();
            UndirectedGraphNode copy = map.get(cur);
            for(UndirectedGraphNode nei:cur.neighbors){
                UndirectedGraphNode newNei = map.get(nei);
                if (newNei==null){
                    deque.addLast(nei);
                    map.put(nei,new UndirectedGraphNode(nei.label));
                }
                copy.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}
