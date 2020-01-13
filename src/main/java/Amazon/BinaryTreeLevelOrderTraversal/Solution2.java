package Amazon.BinaryTreeLevelOrderTraversal;
import java.util.ArrayList;
import java.util.List;
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    void dfs(TreeNode root, int level, List<List<Integer>> res){
        if (root==null) return;
        if(res.size()<level+1) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        dfs(root.left,level+1,res);
        dfs(root.right,level+1,res);
    }
}
