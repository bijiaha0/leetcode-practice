package Amazon.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jiuzhang.com/solutions/letter-combinations-of-a-phone-number/
 * <p>
 * 给一个不包含0和1的数字字符串，每个数字代表一个字母，请返回其所有可能的字母组合。
 * <p>
 * 下图的手机按键图，就表示了每个数字可以代表的字母。
 */
public class Solution {

    public List<String> letterCombinations(String digits) {

        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        dfs(0, digits.length(), "", digits, phone, ans);
        return ans;

    }

    private void dfs(int x, int l, String str, String digits, String[] phone, List<String> ans) {

        //退出
        if (x == l) {
            ans.add(str);
            return;
        }

        //让字符变成真实的数字
        int d = digits.charAt(x) - '0';

        //扩展
        for (char c : phone[d].toCharArray()) {
            dfs(x + 1, l, str + c, digits, phone, ans);
        }

    }

}
