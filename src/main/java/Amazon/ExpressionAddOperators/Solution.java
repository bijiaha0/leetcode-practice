package Amazon.ExpressionAddOperators;
import java.util.ArrayList;
import java.util.List;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 5:11 PM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/expression-add-operators/description
 */
public class Solution {
    void dfs(String num, int target, int start, String str, long sum, long lastF, List<String> ans) {
        if (start == num.length()) {
            if (sum == target) {
                ans.add(str);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            long x = Long.parseLong(num.substring(start, i + 1));
            /*
            * 第一个数字前不能有符号  +3456-23
            * */
            if (start == 0) {
                dfs(num, target, i + 1, "" + x, x, x, ans);
            } else {
                dfs(num, target, i + 1, str + "*" + x, sum - lastF + lastF * x, lastF * x, ans);
                dfs(num, target, i + 1, str + "+" + x, sum + x, x, ans);
                dfs(num, target, i + 1, str + "-" + x, sum - x, -x, ans);
            }
            /*
            * 数字不能有前导0     2543+034
             * */
            if (x == 0) {
                break;
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, "", 0, 0, ans);
        return ans;
    }
}
