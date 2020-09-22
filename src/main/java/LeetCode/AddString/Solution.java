package LeetCode.AddString;

public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int mod = 0;
        while (l1 >= 0 || l2 >= 0) {
            int digis1 = l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int digis2 = l2 < 0 ? 0 : num2.charAt(l2) - '0';
            res.append((mod + digis1 + digis2) % 10);
            mod = (mod + digis1 + digis2) / 10;
            l1--;
            l2--;
        }
        if (mod == 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
