package Amazon.Factorization;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jiuzhang.com/solutions/factorization/
 */
public class Solution01 {

    List<List<Integer>> ans = new ArrayList<>();

    void dfs(int lastF, int remain, List<Integer> item) {

        //边界条件
        if (!item.isEmpty()) {
            item.add(remain);
            ans.add(new ArrayList<Integer>(item));
            item.remove(item.size() - 1);
        }

        //当前层
        for (int i = lastF; i <= remain / i; i++) {
            if (remain % i == 0) {
                List<Integer> new_item = new ArrayList<>(item);//深拷贝
                new_item.add(i);
                dfs(i, remain / i, new_item);
            }
        }

    }

    public List<List<Integer>> getFactors(int n) {
        dfs(2, n, new ArrayList<Integer>());
        return ans;
    }

}
