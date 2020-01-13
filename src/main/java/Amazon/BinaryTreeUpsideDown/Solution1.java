package Amazon.BinaryTreeUpsideDown;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val =val;
    }
}
public class Solution1 {
    public TreeNode flipBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode flippedRoot = flipBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;
        return flippedRoot;
    }
}
