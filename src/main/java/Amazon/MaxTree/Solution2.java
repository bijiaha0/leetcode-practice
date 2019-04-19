package Amazon.MaxTree;

import java.util.Stack;

/**
 * Author: bijiaha0
 * Date: 2019-03-09
 * Time: 14:38
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solution/max-tree/
 */
public class Solution2 {
    /**
     * @param A
     *            : Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public static TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        for (int i = 0; i <= A.length; i++) {
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
                    : new TreeNode(A[i]);
            while (!stack.isEmpty()) {
                if (right.val > stack.peek().val) {
                    TreeNode nodeNow = stack.pop();
                    if (stack.isEmpty()) {
                        right.left = nodeNow;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val > right.val) {
                            right.left = nodeNow;
                        } else {
                            left.right = nodeNow;
                        }
                    }
                } else
                    break;
            }
            stack.push(right);
        }
        return stack.peek().left;
    }
}
