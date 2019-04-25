package LeetCode.PlusOne;
/**
 * Time: 20:27
 * Email: clickgwas@gmail.com
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int carry = 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (carry == 0) {
                return digits;
            }
            if(carry == 1){
                int sum = digits[i] + carry;
                digits[i] = sum % 10;
                carry = sum / 10;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return carry == 0 ? digits : res;
    }
}
