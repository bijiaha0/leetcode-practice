package Amazon.WordAbbreviation;
import java.util.HashMap;
import java.util.Map;
/**
 * https://www.lintcode.com/problem/word-abbreviation/solution
 */
public class Solution {
    public String[] wordsAbbreviation(String[] dict) {
        int len = dict.length;
        String[] ans = new String[len];
        int round = 1;
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < len; i++) {
            ans[i] = getAbbr(dict[i], round);
            count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
        }
        while (true) {
            boolean unique = true;
            round++;
            for (int i = 0; i < len; i++) {
                if (count.get(ans[i]) > 1) {
                    ans[i] = getAbbr(dict[i], round);
                    count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
                    unique = false;
                }
            }
            if (unique) {
                break;
            }
        }
        return ans;
    }
    String getAbbr(String s, int p) {
        if (p >= s.length() - 2) {
            return s;
        }
        return s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
    }
}
