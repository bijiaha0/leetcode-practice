package Amazon.PathSumIII;
import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        addPath(root, sum, new ArrayList(), res);
        return res;
    }

    public void addPath(TreeNode root, int sum, List tmp, List res) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(tmp);
        } else {
            addPath(root.left, sum - root.val, tmp, res);
            addPath(root.right, sum - root.val, tmp, res);
        }
        tmp.remove(tmp.size() - 1);
    }
}
