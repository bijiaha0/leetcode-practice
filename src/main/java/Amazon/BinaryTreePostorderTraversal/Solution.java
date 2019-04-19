package Amazon.BinaryTreePostorderTraversal;
import java.util.ArrayList;
/**
 * Email: clickgwas@gmail.com
 * Recursive
 * https://www.jiuzhang.com/solutions/binary-tree-postorder-traversal/
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;
    }
}
