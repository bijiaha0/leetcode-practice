package Amazon.MaximumBinaryTree;

import java.util.Stack;

public class Solution1 {
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < A.length; i++) {
            TreeNode node = new TreeNode(A[i]);
            while (!stack.isEmpty() && node.val >= stack.peek().val) {
                node.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }

        TreeNode rst = stack.pop();
        while(!stack.isEmpty()) {
            rst = stack.pop();
        }
        return rst;
    }
}
