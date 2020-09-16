package Amazon.AddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jiuzhang.com/solutions/add-operators/
 * <p>
 * 给定一个仅包含数字 0 - 9 的字符串和一个目标值，返回在数字之间添加了 二元 运算符(不是一元)+, - 或 * 之后所有能得到目标值的情况。
 * <p>
 * 输入:
 * "123"
 * 6
 * 输出:
 * ["1*2*3","1+2+3"]
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
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, "", 0, 0, ans);
        return ans;
    }
}
