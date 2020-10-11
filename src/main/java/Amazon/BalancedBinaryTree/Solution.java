package Amazon.BalancedBinaryTree;

/**
 * https://www.jiuzhang.com/solutions/balanced-binary-tree/
 * 给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：
 * 一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 */
class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}

public class Solution {

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
