package LeetCode.ValidPalindrome;
/**
 * https://www.jiuzhang.com/solution/valid-palindrome/
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isValid(s.charAt(front))) { // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for empty string “.,,,”
                return true;
            }

            while (end >= 0 && !isValid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            }
            if (Character.toLowerCase(s.charAt(front)) == Character.toLowerCase(s.charAt(end))) {
                front++;
                end--;
            }
        }

        return end <= front;
    }

    //
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
