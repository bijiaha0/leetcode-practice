package LeetCode.SearchInABinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        //return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
        if(root.val > val){
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }
    }
}
