package Amazon.Factorization;


import java.util.ArrayList;
import java.util.List;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/27 3:12 PM
 */
public class Solution2 {

    public List<List<Integer>> getFactors(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(2, n, path, ans);

        return ans;
    }

    void dfs(int start, int remain, List<Integer> path, List<List<Integer>> ans) {

        if (!path.isEmpty()) {
            path.add(remain);
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < remain / i; i++) {
            if (remain % i == 0) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(start);
                dfs(i, remain / i, newPath, ans);
            }
        }
    }


}
