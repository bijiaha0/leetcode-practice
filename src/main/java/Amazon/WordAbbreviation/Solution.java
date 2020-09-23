package Amazon.WordAbbreviation;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.jiuzhang.com/problem/word-abbreviation/
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

    String getAbbr(String s, int prefix) {
        //-1 表示最后一个字母
        //-1 表示数字
        //prefix 表示前缀
        if (prefix >= (s.length() - 1) - 1) {
            return s;
        }

        return s.substring(0, prefix) + (s.length() - 1 - prefix) + s.charAt(s.length() - 1);
    }

}
