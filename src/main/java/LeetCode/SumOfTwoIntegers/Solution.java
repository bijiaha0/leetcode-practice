package LeetCode.SumOfTwoIntegers;

/**
 * @author bijh@tsingyun.net
 * @date 2020/4/4 4:49 PM
 * https://leetcode.com/problems/sum-of-two-integers/
 * id = 371
 */
public class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
    public int getSum1(int a, int b){
        if (b==0) {
            return a;
        }
        while (b!=0){
            int sum = a^b;
            int carry  = (a&b)<<1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
