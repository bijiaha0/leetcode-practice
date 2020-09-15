package Amazon.FirstPositionUniqueCharacter;

/**
 * https://www.jiuzhang.com/solutions/first-position-unique-character/
 */
public class Solution {

    public int firstUniqChar(String s) {

        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

}
