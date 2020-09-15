package Amazon.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.jiuzhang.com/solutions/binary-tree-inorder-traversal/
 * 二叉树的中序遍历 · Binary Tree Inorder Traversal
 * 二叉树遍历分为三种：前序、中序、后序，其中序遍历最为重要。是根据根节点的顺序命名的。
 */
class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;

        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }

        return result;

    }

}
