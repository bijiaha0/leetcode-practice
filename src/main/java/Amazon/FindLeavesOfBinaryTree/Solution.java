package Amazon.FindLeavesOfBinaryTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 2:07 PM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/find-leaves-of-binary-tree/description
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val =val;
    }
}
public class Solution {
    int dfs(TreeNode cur, Map<Integer, List<Integer>> depth) {
        if (cur == null) {
            return 0;
        }
        int d = Math.max(dfs(cur.left, depth), dfs(cur.right, depth)) + 1;
        //putIfAbsent   如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null.
        depth.putIfAbsent(d, new ArrayList<>());
        depth.get(d).add(cur.val);
        return d;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> depth = new HashMap<>();
        int max_depth = dfs(root, depth);
        for (int i = 1; i <= max_depth; i++) {
            ans.add(depth.get(i));
        }
        return ans;
    }
}