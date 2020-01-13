package Amazon.InvertBinaryTree;
/**
 * Author: bijiaha0
 * Date: 2019-05-25
 * Time: 14:44
 * Email: clickgwas@gmail.com
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp1 = invertTree(root.right);
        TreeNode tmp2 = invertTree(root.left);
        root.right = tmp2;
        root.left = tmp1;
        return root;
    }
}
