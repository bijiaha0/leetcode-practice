package Amazon.FindAllAnagramsInAString;
import java.util.ArrayList;
import java.util.List;
/**
 * https://www.lintcode.com/problem/find-all-anagrams-in-a-string/description
 *
 * 输入 : s = "cbaebabacd", p = "abc"
 * 输出 : [0, 6]
 * 说明 :
 * 子串起始索引 index = 0 是 "cba"，是"abc"的字谜。
 * 子串起始索引 index = 6 是 "bac"，是"abc"的字谜。
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        int[] det = new int[256];

        for (int i = 0; i < p.length(); i++) {
            det[pc[i]]--;
            det[sc[i]]++;
        }

        int absSum = 0;
        for (int item : det) {
            absSum += Math.abs(item);
        }
        if (absSum == 0) {
            ans.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            int r = sc[i];
            int l = sc[i - p.length()];
            absSum = absSum - Math.abs(det[r]) - Math.abs(det[l]);

            det[r]++;
            det[l]--;

            absSum = absSum + Math.abs(det[r]) + Math.abs(det[l]);
            if (absSum == 0) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}
