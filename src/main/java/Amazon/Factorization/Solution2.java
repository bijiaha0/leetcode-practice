package Amazon.Factorization;


import java.util.ArrayList;
import java.util.List;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/27 3:12 PM
 *
 * https://www.programcreek.com/2014/07/leetcode-factor-combinations-java/
 */
public class Solution2 {

    public List<List<Integer>> getFactors(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(2, 1, n, path, ans);

        return ans;
    }

    void dfs(int start, int product, int n, List<Integer> path, List<List<Integer>> ans) {

        if (start > n || product > n) {
            return;
        }

        if (product == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < n; i++) {
            if (i * product > n) {
                break;
            }

            if (n % i == 0) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(i);
                dfs(i, i * product, n, newPath, ans);
            }
        }
    }


}
