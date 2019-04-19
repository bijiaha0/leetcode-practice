package Amazon.AddBinary;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 11:25 PM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/add-binary/description
 * 二进制相加
 */
public class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            ans = (sum % 2) + ans;
            carry = sum / 2;
        }
        if (carry != 0) {
            ans = carry + ans;
        }
        return ans;
    }
}
