package Amazon.BinaryTreeFlipping;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/16 8:27 AM
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    TreeNode dfs(TreeNode cur) {
        if (cur.left == null) {
            return cur;
        }
        TreeNode newRoot = dfs(cur.left);
        cur.left.right = cur;
        cur.left.left = cur.right;
        cur.left = null;            // important
        cur.right = null;
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        return dfs(root);
    }
}
