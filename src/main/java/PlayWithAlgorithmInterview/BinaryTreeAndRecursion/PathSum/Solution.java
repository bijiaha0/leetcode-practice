package PlayWithAlgorithmInterview.BinaryTreeAndRecursion.PathSum;
//  111
//  404
/// 112. SuanFaNeiGong.GraphBasics.ChapterCompletedCode.SuanFaNeiGong.GraphBasics.BFSAndShortestPath.SuanFaNeiGong.GraphBasics.Path Sum
/// https://leetcode.com/problems/path-sum/description/
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
class Solution {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        //root是叶子节点
        if(root.left == null && root.right == null)
            return sum == root.val;
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}