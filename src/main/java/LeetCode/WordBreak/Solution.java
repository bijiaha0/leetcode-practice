package LeetCode.WordBreak;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: bijiaha0
 * Date: 2019-04-21
 * Time: 08:54
 * Email: clickgwas@gmail.com
 * https://segmentfault.com/a/1190000002708290
 *
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {
    private Set<String> unmatch = new HashSet<String>();

    public boolean wordBreak(String s, Set<String> dict) {
        for (String prefix : dict) {
            if (s.equals(prefix))
                return true;
            if (s.startsWith(prefix)) {
                String suffix = s.substring(prefix.length(), s.length());
                if (!unmatch.contains(suffix)) {
                    if (wordBreak(suffix, dict))
                        return true;
                    else
                        unmatch.add(suffix);
                }
            }
        }
        return false;
    }
}
