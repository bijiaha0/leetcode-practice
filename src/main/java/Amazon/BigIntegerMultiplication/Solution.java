package Amazon.BigIntegerMultiplication;

/**
 * https://www.jiuzhang.com/solutions/add-two-numbers/
 * 高精度乘法的实现
 * 数位相乘ans[i+j] +=a[i]*b[j]
 */

public class Solution {

    public static String mutiply(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();

        int[] ans = new int[l1 + l2 + 1];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(i) - '0');
            }
        }

        for (int i = 0; i < ans.length - 1; i++) {
            ans[i + 1] += ans[i] / 10;
            ans[i] = ans[i] % 10;
        }

        int i = l1 + l2;
        while (ans[i] == 0 && i >= 1) {
            i--;
        }
        String str = "";
        while (i >= 0) {
            str += ans[i--];
        }
        return str;
    }

}
