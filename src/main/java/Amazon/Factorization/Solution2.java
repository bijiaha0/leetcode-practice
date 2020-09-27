package Amazon.Factorization;


import java.util.ArrayList;
import java.util.List;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/27 3:12 PM
 * <p>
 * https://www.programcreek.com/2014/07/leetcode-factor-combinations-java/
 * <p>
 * https://www.jiuzhang.com/solutions/factorization/
 * <p>
 * 输入：8
 * 输出： [[2,2,2],[2,4]]
 * 解释： 8 = 2 x 2 x 2 = 2 x 4
 */
public class Solution2 {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(2, 1, n, result, list);
        return result;
    }

    public void dfs(int start, int product, int n, List<List<Integer>> result, List<Integer> curr) {
        if (start > n || product > n) {
            return;
        }

        if (product == n) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < n; i++) {
            if (i * product > n)
                break;

            if (n % i == 0) {
                curr.add(i);
                dfs(i, i * product, n, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
