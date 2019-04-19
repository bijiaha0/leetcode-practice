package Amazon.BinaryTreeLevelOrderTraversal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * https://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
 * 图的层级遍历
 * 树是图的一种特殊形态，树属于图
 * 需要分层的算法比不需要分层的算法多一个循环
 */
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
// version 1: BFS  层序遍历
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();//queue.size()是变化的
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
