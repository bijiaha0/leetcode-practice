package Amazon.MinimumSubtree;

/**
 * Author: bijiaha0
 * Date: 2019-03-03
 * Time: 15:36
 * Email: clickgwas@gmail.com
 */
class ResultType {
    public TreeNode minSubtree;
    public int sum, minSum;
    public ResultType(TreeNode minSubtree, int minSum, int sum) {
        this.minSubtree = minSubtree;
        this.minSum = minSum;
        this.sum = sum;
    }
}
public class Solution2 {
    public TreeNode findSubtree(TreeNode root) {
        ResultType result = helper(root);
        return result.minSubtree;
    }

    public ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }

        ResultType leftResult = helper(node.left);
        ResultType rightResult = helper(node.right);

        ResultType result = new ResultType(
                node,
                leftResult.sum + rightResult.sum + node.val,
                leftResult.sum + rightResult.sum + node.val
        );

        if (leftResult.minSum <= result.minSum) {
            result.minSum = leftResult.minSum;
            result.minSubtree = leftResult.minSubtree;
        }

        if (rightResult.minSum <= result.minSum) {
            result.minSum = rightResult.minSum;
            result.minSubtree = rightResult.minSubtree;
        }

        return result;
    }
}
