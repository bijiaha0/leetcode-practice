package Amazon.LongestSubstringWithoutRepeatingCharacters;
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring1(String s) {
        int i, j = 0, ans = 0, n = s.length();
        char[] sc = s.toCharArray();
        int[] map = new int[256];
        for (i = 0; i < n; i++) {
            while (j < n && map[sc[j]] == 0) {
                map[sc[j]] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            map[sc[i]] = 0;
        }
        return ans;
    }
}
