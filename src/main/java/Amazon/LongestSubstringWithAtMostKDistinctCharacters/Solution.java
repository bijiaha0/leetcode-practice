package Amazon.LongestSubstringWithAtMostKDistinctCharacters;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = 0;
        int i, j = 0;
        char[] sc = s.toCharArray();
        Map<Character, Integer> hs = new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            while (j < s.length()&& hs.size() < k) {
                if (hs.containsKey(sc[j])) {
                    hs.put(sc[j], hs.get(sc[j]) + 1);
                } else {
                    hs.put(sc[j], 1);
                }
                j++;
            }
            if(hs.size() >= k){
                len = Math.max(len, j - i);
            }
            if (hs.containsKey(sc[i])) {
                if (hs.get(sc[i]) > 1) {
                    hs.put(sc[i], hs.get(sc[i]) - 1);
                } else {
                    hs.remove(sc[i]);
                }
            }
        }
        return len;
    }
}