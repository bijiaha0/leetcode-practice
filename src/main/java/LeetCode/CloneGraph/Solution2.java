package LeetCode.CloneGraph;
import java.util.HashMap;
/**
 * dfs
 */
public class Solution2 {
    //新创建的点
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        //克隆节点
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        //放入缓存
        map.put(node, cloneNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(clone(neighbor));
        }
        return cloneNode;
    }
}
