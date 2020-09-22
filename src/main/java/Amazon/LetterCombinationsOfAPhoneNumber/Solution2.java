package Amazon.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;

/**
 * @author bijh@tsingyun.net
 * @date 2020/9/22 10:39 AM
 *
 * 中间不改变的东西，可以放到成员变量中去。
 */
public class Solution2 {

    ArrayList<String> ans = new ArrayList<>();
    int l;
    String digits;
    static final String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    void dfs(int x, String str) {

        if (x == l) {
            ans.add(str);
            return;
        }
        int index = digits.charAt(x) - '0';
        for (char c : phone[index].toCharArray()) {
            dfs(x + 1, str + c);
        }

    }

    public ArrayList<String> letterCombinations(String digits) {

        this.l = digits.length();
        this.digits = digits;

        if (digits.length() == 0) {
            return ans;
        }

        dfs(0, "");

        return ans;
    }


}
