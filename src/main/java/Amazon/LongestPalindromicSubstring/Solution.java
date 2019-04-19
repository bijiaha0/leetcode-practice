package Amazon.LongestPalindromicSubstring;
/**
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/longest-palindromic-substring/description
 * 基于中心点枚举的算法，时间复杂度 O(n^2)
 */
public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, len = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            //1 2 1
            len = findLongestPalindromeFrom(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }
            //12  21
            len = findLongestPalindromeFrom(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
        }

        return s.substring(start, start + longest);
    }

    private int findLongestPalindromeFrom(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            len += left == right ? 1 : 2;
            left--;
            right++;
        }
        return len;
    }
}
