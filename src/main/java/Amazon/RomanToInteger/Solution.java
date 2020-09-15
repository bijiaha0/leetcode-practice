package Amazon.RomanToInteger;
/**
 *
 *
 *
 *
 *
 *
 *
 *
 * https://www.lintcode.com/problem/roman-to-integer/description
 * 像IV=4 IX=9 XL=40 XC=90 这样的怎么处理呢？
 * 没有 4 9 40 90 这种的，字母代表的数字从左往右是从大到小的
 * 发现左边的如果小于右边，就把左边的减去.
 *
 *
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
