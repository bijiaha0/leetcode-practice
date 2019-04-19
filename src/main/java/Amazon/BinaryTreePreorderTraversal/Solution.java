package Amazon.BinaryTreePreorderTraversal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 二叉树前序遍历
 * https://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
 * Version 0: Non-Recursion (Recommend)
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return preorder;
    }
}
