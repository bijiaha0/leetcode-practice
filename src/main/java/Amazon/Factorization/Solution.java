package Amazon.Factorization;
import java.util.ArrayList;
import java.util.List;
/**
 * https://www.lintcode.com/problem/factorization/description
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    void dfs(int start, int remain) {
        //边界条件
        if (!path.isEmpty()) {
            path.add(remain);
            ans.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
        }
        //当前层
        for (int i = start; i <= remain / i; i++) {
            if (remain % i == 0) {
                path.add(i);
                dfs(i, remain / i);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        dfs(2, n);
        return ans;
    }
}
