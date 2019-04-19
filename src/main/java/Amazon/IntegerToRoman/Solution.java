package Amazon.IntegerToRoman;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 12:28 AM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/integer-to-roman/description
 * 如何将一个数转成k进制------   %k ， /k
 */
public class Solution {
    public String intToRoman(int n) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[n / 1000] + C[(n / 100) % 10] + X[(n / 10) % 10] + I[n % 10];
    }
}
