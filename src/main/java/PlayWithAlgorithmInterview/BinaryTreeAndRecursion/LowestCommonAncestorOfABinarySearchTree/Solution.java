package PlayWithAlgorithmInterview.BinaryTreeAndRecursion.LowestCommonAncestorOfABinarySearchTree;
// 98  亚马逊
// 450
// 108 有序数组——————> 平衡二分搜索树
// 230 二分搜索树，第k小元素
// 236 任意的二叉树中，寻找这两个节点的最近公共祖先。
// 235. Lowest Common Ancestor of a Binary Search Tree
/// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
/// 时间复杂度: O(lgn), 其中n为树的节点个数
/// 空间复杂度: O(h), 其中h为树的高度
class Solution {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == null || q == null)
            throw new IllegalArgumentException("p or q can not be null.");
        if(root == null)
            return null;
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        assert p.val == root.val || q.val == root.val
                || (root.val - p.val) * (root.val - q.val) < 0;
        return root;
    }
}
