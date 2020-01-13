package LeetCode.ValidateBinarySearchTree;
public class Solution2 {
    private boolean isValid = true;
    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre != null && pre.val >= root.val) {
            isValid = false;
            return;
        }
        pre = root;
        helper(root.right);
    }
}
