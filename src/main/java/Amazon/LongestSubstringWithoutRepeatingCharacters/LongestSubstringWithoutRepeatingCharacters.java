package Amazon.LongestSubstringWithoutRepeatingCharacters;
import java.util.HashSet;
import java.util.Set;
/**
 * Email: clickgwas@gmail.com
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
/*
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
* */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public int lengthOfLongestSubstring1(String s) {
        int i =0, j =0;
        int ans = 0;
        int[] map = new int[256];
        for(i =0 ;i < s.length();i++){
            while(j< s.length() && map[s.charAt(j)]==0){
                map[s.charAt(j)] =1;
                ans = Math.max(ans,j-i+1);
                j++;
            }
            map[s.charAt(i)] =0;
        }
        return ans;
    }
}
