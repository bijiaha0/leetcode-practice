package Amazon.BinaryTreeVerticalOrderTraversal;
import java.util.*;
/**
 * 给定二叉树，返回其节点值的垂直遍历顺序。 (即逐列从上到下)。如果两个节点在同一行和同一列中，则顺序应 从左到右。
 * https://www.jiuzhang.com/solutions/binary-tree-vertical-order-traversal/
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val =val;
    }
}

public class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, List<Integer>> hash = new HashMap<>();
        Queue<Integer> qCol = new LinkedList<>();
        Queue<TreeNode> qNode = new LinkedList<>();

        qCol.offer(0);
        qNode.offer(root);

        while (!qCol.isEmpty()) {                      // bfs
            int c = qCol.poll();
            TreeNode node = qNode.poll();
            hash.putIfAbsent(c, new ArrayList<>());
            hash.get(c).add(node.val);
            if (node.left != null) {
                qCol.offer(c - 1);
                qNode.offer(node.left);
            }
            if (node.right != null) {
                qCol.offer(c + 1);
                qNode.offer(node.right);
            }
        }

        for (int i = Collections.min(hash.keySet()); i <= Collections.max(hash.keySet()); i++) {
            ans.add(hash.get(i));
        }

        return ans;
    }

}