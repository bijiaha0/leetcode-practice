package Amazon.MinimumSubtree;
/**
 * https://www.jiuzhang.com/solutions/minimum-subtree/
 * 给一棵二叉树, 找到和为最小的子树, 返回其根节点。
 * traverse + divide conquer
 */
public class Solution {
    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum <= subtreeSum) {
            subtreeSum = sum;
            subtree = root;
        }
        return sum;
    }
}
