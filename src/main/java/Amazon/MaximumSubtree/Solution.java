package Amazon.MaximumSubtree;

/**
 * https://www.jiuzhang.com/solutions/minimum-subtree/
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
    public static TreeNode result = null;
    public static int maximum_weight = Integer.MIN_VALUE;

    public static TreeNode findSubtree(TreeNode root) {
        helper(root);
        return result;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_weight = helper(root.left);
        int right_weight = helper(root.right);
        if (result == null || left_weight + right_weight + root.val > maximum_weight) {
            maximum_weight = left_weight + right_weight + root.val;
            result = root;
        }
        return left_weight + right_weight + root.val;
    }

    public static void main(String[] args) {
    }
}
