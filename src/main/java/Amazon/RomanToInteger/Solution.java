package Amazon.RomanToInteger;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 12:22 AM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/roman-to-integer/description
 */
public class Solution {
    public int romanToInt(String s) {
        int ans;
        char[] sc = s.toCharArray();
        ans = toInt(sc[0]);                        //0 special
        for (int i = 1; i < s.length(); i++) {
            ans += toInt(sc[i]);
            if (toInt(sc[i - 1]) < toInt(sc[i])) {
                ans -= toInt(sc[i - 1]) * 2;//前面多加了一个
            }
        }
        return ans;
    }
    int toInt(char s) {
        switch(s) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
