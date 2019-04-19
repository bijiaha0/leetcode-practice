package Amazon.MaximumDepthOfBinaryTree;
/**
 * 二叉树的最大深度
 * https://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//分治法
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
