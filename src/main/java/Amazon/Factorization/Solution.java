package Amazon.Factorization;
import java.util.ArrayList;
import java.util.List;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/factorization/description
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    void dfs(int start, int remain) {
        if (remain == 1) {
            if (path.size() != 1) {
                ans.add(new ArrayList<>(path)); //deep copy
            }
            return;
        }
        for (int i = start; i <= remain; i++) {
            if (i > remain / i) {
                break;
            }
            if (remain % i == 0) {
                path.add(i);                  //进栈      改变    滚动
                dfs(i, remain / i);
                path.remove(path.size() - 1); //出栈    还原    滚动
            }
        }
        path.add(remain);
        dfs(remain, 1);
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> getFactors(int n) {
        dfs(2, n);
        return ans;
    }
}
