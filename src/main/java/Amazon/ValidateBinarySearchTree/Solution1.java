package Amazon.ValidateBinarySearchTree;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solutions/validate-binary-search-tree/
 * 采用分治法，时间复杂度 O(n)O(n)
 */
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class Solution1 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divConq(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return divConq(root.left, min, Math.min(max, root.val)) && divConq(root.right, Math.max(min, root.val), max);
    }

}
