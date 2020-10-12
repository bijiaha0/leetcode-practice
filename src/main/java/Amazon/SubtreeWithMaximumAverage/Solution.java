package Amazon.SubtreeWithMaximumAverage;
/**
 * https://www.jiuzhang.com/solutions/subtree-with-maximum-average/
 * 具有最大平均数的子树
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
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    // 定义数据返回类型，包括子树的所有节点权值之和&子树节点数目
    private class Result{
        int sum, num;
        public Result(int sum, int num) {
            this.sum = sum;
            this.num = num;
        }
    }

    // maxAverage表示最大平均值子树的根结点
    private TreeNode maxAverage = null;
    // maxAverageData记录最大平均值子树的所有权值之和&子树节点数目
    private Result maxAverageData = null;

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        // 分别递归求解左右子树的所有权值之和&子树节点数目
        Result left = dfs(root.left);
        Result right = dfs(root.right);

        Result rootResult = new Result(left.sum + right.sum + root.val, left.num + right.num + 1);
        // 如果最大平均值子树为空，或者当前子树平均值大于原maxAverage，更新maxAverage
        if(maxAverage == null || maxAverageData.num * rootResult.sum > maxAverageData.sum * rootResult.num) {
            maxAverage = root;
            maxAverageData = rootResult;
        }
        return rootResult;
    }

    public TreeNode findSubtree2(TreeNode root) {
        dfs(root);
        return maxAverage;
    }
}
