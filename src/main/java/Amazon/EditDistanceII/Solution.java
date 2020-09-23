package Amazon.EditDistanceII;

/**
 * https://www.jiuzhang.com/solutions/edit-distance-ii/
 * 给定两个字符串 S 和 T, 判断T是否可以通过对S做刚好一次编辑得到。
 * 每次编辑可以选择以下任意一个操作：
 *
 * 在S的任意位置插入一个字符
 * 删除S中的任意一个字符
 * 将S中的任意字符替换成其他字符
 */
public class Solution {

    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {

        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }

        int diff = t.length() - s.length();

        if (diff > 1) {
            return false;
        }

        if (diff == 0) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    cnt++;
                }
            }
            return (cnt == 1);
        }

        if (diff == 1) {
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    return (s.substring(i).equals(t.substring(i + 1)));
                }
            }
        }

        return true;
    }
}