package Amazon.BinaryTreeUpsideDown;
/**
 * https://www.lintcode.com/problem/binary-tree-upside-down/description
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
    TreeNode newRoot;
    void dfs(TreeNode cur) {
        if (cur.left == null) {
            newRoot = cur;
            return;
        }
        dfs(cur.left);
        cur.left.right = cur;
        cur.left.left = cur.right;
        cur.left = null;            // important
        cur.right = null;
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return newRoot;
    }
}
