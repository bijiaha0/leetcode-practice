package Amazon.MaximumBinaryTree;

import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
 TreeNode(int x) { val = x; }
}
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            // Pop the smaller node in the stack and set as left child of currNode.
            // Loop until the largest candidate is found, and only then, settle on it.
            while (!stack.isEmpty() && num >= stack.peek().val) {
                node.left = stack.pop();
            }

            // Set node as right children, if stack is not empty: there must be larger node.
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }

            // Push node, as the being largest of all, into the stack.
            stack.push(node);
        }

        // Find root
        TreeNode root = stack.pop();
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        return root;
    }
}
