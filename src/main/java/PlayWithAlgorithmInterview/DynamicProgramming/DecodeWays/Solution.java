package PlayWithAlgorithmInterview.DynamicProgramming.DecodeWays;
/**
 动态规划.
 设定状态: f[i] 表示字符串前i位有多少种解码方案
 状态转移方程:
 初始化 f 数组为 0
 若字符串中 s[i] 表示的阿拉伯数字在 1~9 范围内, f[i] += f[i-1]
 若s[i-1]和s[i]连起来表示的数字在 10~26 范围内, f[i] += f[i-2] (若i==1, 则f[i] += 1)
 边界: f[0] = 1
 特判:
 如果字符串以 '0' 开头, 则直接返回0.
 如果运算中发现 f[i] == 0, 则说明此处无法解码, 同样直接返回0.
 https://www.jiuzhang.com/solutions/decode-ways/
 */
public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public static int numDecodings(String s) {
        // Write your code here
        int l = s.length();
        if (l == 0) {
            return 0;   // only for this problem, but the ans should be 1
        }
        int[] f = new int[l + 1];
        f[0] = 1;
        char sc[] = s.toCharArray();

        for (int i = 1; i <= l; i++) {
            if (sc[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i >= 2) {
                int val2 = (sc[i - 2] - '0') * 10 + sc[i - 1] - '0';
                if (10 <= val2 && val2 <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[l];
    }

    public static void main(String[] args) {
        int i = numDecodings("1234324");
        System.out.println(i);
    }
}
