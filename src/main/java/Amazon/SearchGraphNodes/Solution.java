package Amazon.SearchGraphNodes;
import java.util.*;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solutions/search-graph-nodes/
 * 搜索图中节点
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class Solution {
    public UndirectedGraphNode searchNode(Map<UndirectedGraphNode, Integer> values, UndirectedGraphNode node, int target) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();

        queue.offer(node);
        hash.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            if (values.get(head) == target) {
                return head;
            }
            for (UndirectedGraphNode nei : head.neighbors) {
                if (!hash.contains(nei)){
                    queue.offer(nei);
                    hash.add(nei);
                }
            }
        }
        return null;
    }
}
