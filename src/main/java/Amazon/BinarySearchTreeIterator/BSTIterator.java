package Amazon.BinarySearchTreeIterator;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTIterator {

    public BSTIterator(TreeNode root) {
        next = root;
    }

    private Stack<TreeNode> stack = new Stack<>();

    TreeNode next = null;

    void AddNodeToStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        if (next != null) {
            AddNodeToStack(next);
            next = null;
        }
        return !stack.isEmpty();
    }

    public TreeNode next() {
        if (!hasNext()) {
            return null;
        }
        TreeNode cur = stack.pop();
        next = cur.right;
        return cur;
    }

}