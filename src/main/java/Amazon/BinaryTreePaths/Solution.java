package Amazon.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jiuzhang.com/solutions/binary-tree-paths/
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
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
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<String>();

        if (root == null) {
            return result;
        }

        helper(root, String.valueOf(root.val), result);

        return result;
    }

    private void helper(TreeNode root, String path, List<String> result) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if (root.left != null) {
            helper(root.left, path + "->" + root.left.val, result);
        }

        if (root.right != null) {
            helper(root.right, path + "->" + root.right.val, result);
        }

    }

}
