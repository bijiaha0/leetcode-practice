package LeetCode.CheckWordAbbreviation;
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        char[] s = word.toCharArray();
        char[] t = abbr.toCharArray();
        while (i < s.length && j < t.length) {
            if (Character.isDigit(t[i])) {
                if (t[i] == '0') {
                    return false;
                }
                int val = 0;
                while (i < s.length && j < t.length && Character.isDigit(t[j])) {
                    val = val * 10 + t[j];
                    j++;
                }
                i += val;
                if (s[i++] != t[j++]) {
                    return false;
                }
            }
        }
        return i == s.length && j == t.length;
    }
}
