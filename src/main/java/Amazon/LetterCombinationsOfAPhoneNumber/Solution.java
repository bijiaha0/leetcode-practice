package Amazon.LetterCombinationsOfAPhoneNumber;
import java.util.ArrayList;
import java.util.List;
/**
 * Email: clickgwas@gmail.com
 * Amazon 电面题
 * 枚举   深度遍历
 * https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description
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
    //x当前搜到第几层
    //l 一共要搜多少层
    //str 当前的路径
    //digits 输入
    //phone[] 对应关系
    //ans 输出
    private void dfs(int x, int l, String str, String digits, String[] phone, List<String> ans) {
        if (x == l) {//退出
            ans.add(str);
            return;
        }
        int d = digits.charAt(x) - '0';//让字符变成真实的数字
        for (char c : phone[d].toCharArray()) {
            dfs(x + 1, l, str + c, digits, phone, ans);
        }
    }
}
