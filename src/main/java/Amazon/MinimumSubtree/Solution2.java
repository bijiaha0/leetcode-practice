package Amazon.MinimumSubtree;


/**
 * https://www.jiuzhang.com/solutions/minimum-subtree/
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

public class Solution2 {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode minSubtree;
    public int minSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        getSum(root);
        return minSubtree;
    }

    private int getSum(TreeNode node){
        if(node == null) {
            return 0;
        }
        int left = getSum(node.left);
        int right = getSum(node.right);
        int curtSum = left + right + node.val;
        if(curtSum < minSum) {
            this.minSubtree = node;
            this.minSum = curtSum;
        }
        return curtSum;
    }
}

