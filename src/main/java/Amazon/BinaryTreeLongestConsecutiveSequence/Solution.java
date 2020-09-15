package Amazon.BinaryTreeLongestConsecutiveSequence;

/**
 * https://www.jiuzhang.com/solutions/binary-tree-longest-consecutive-sequence/
 * 二叉树最长连续序列
 */
class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

}

public class Solution {

    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int lengthWithoutRoot) {

        if (root == null) {
            return 0;
        }

        int length = (parent != null && parent.val + 1 == root.val) ? lengthWithoutRoot + 1 : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));

    }
}
