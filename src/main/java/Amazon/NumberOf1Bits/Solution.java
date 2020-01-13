package Amazon.NumberOf1Bits;
public class Solution {
    public static int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n&1);
            n = n>>>1;
        }
        return ones;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);//清除最低位的1
            count++;
        }
        return count;
    }
}
