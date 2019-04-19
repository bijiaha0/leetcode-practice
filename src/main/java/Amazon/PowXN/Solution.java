package Amazon.PowXN;
import java.util.ArrayList;
import java.util.List;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 11:38 PM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/powx-n/description
 * 快速幂
 * 十进制转二进制  %2  /2
 */
public class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        //当n是负数的情况
        if (n < 0) {
            x = 1 / x;
            isNegative = true;
            n = -(n + 1);       // Avoid overflow when n == MIN_VALUE
        }
        double ans = 1, tmp = x;
        while (n != 0) {
            if (n % 2 == 1) {  //求二进制的话，是先模2，再除以2、最后倒序就是二进制
                ans *= tmp;
            }
            tmp *= tmp;  //x^2、x^4、x^8
            n /= 2;
        }
        if (isNegative) {
            ans *= x;
        }
        return ans;
    }
    public double myPow1(double x, int n) {
        //当n是负数的情况
        if (n < 0) {
            x = 1 / x;
            n = -n;       // Avoid overflow when n == MIN_VALUE
        }
        double ans = 1, tmp = x;
        while (n != 0) {
            if (n % 2 == 1) {  //求二进制的话，是先模2，再除以2、最后倒序就是二进制
                ans *= tmp;
            }
            tmp *= tmp;  //x^2、x^4、x^8
            n /= 2;
        }
        return ans;
    }
    public double myPow2(double x, int n) {
        //当n是负数的情况
        if (n < 0) {
            x = 1 / x;
            n = -n;       // Avoid overflow when n == MIN_VALUE
        }
        List<Integer> digits = new ArrayList<>();
        //求二进制---倒序扔进list
        while (n != 0){
            digits.add(n % 2);
            n /= 2;
        }
        /*
        * 打印二进制
        * */
        for(int i = digits.size()-1;i>=0;i--){
            System.out.print(digits.indexOf(i)+" ");
        }

        double ans = 1, tmp = x;
        for(int item:digits){
            if(item==1){
                ans *= tmp;
            }
            tmp *= tmp;
        }
        return ans;
    }
}
