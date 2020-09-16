package Amazon.Factorization;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jiuzhang.com/solutions/factorization/
 * <p>
 * 输入：8
 * 输出： [[2,2,2],[2,4]]
 * 解释： 8 = 2 x 2 x 2 = 2 x 4
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    void dfs(int start, int remain) {

        //边界条件
        if (!path.isEmpty()) {
            path.add(remain);
            ans.add(new ArrayList<>(path));
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
