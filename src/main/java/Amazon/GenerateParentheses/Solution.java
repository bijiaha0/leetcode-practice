package Amazon.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, 0, 0);
        return res;
    }

    void dfs(List<String> res, String tmp, int n, int left, int right) {
        if (left == n && right == n) {
            res.add(tmp);
            return;
        }
        if (left < n) {
            dfs(res, tmp + '(', n, left + 1, right);
        }
        if (left > right && right < n) {
            dfs(res, tmp + ')', n, left, right + 1);
        }
    }
}
