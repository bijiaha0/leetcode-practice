package LeetCode.FeiBoNaQie;
import java.util.Arrays;
/**
 * Author: bijiaha0
 * Date: 2019-04-23
 * Time: 12:15
 * Email: clickgwas@gmail.com
 * recursion
 */
public class Solution {
    public static int fei(int n) {

        if (n < 1) {
            return 0;
        }

        if(n==1|n==2){
            return 1;
        }

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        memo[2] = 1;

        return getMemo(n, memo);
    }

    private static int getMemo(int n, int[] memo) {

        if (memo[n] == -1) {
            memo[n] = getMemo(n-1, memo) + getMemo(n-2, memo);
        }
        return memo[n];

    }

    public static void main(String[] args) {

        for(int j =1; j<=6; j++){
            System.out.println(fei(j));
        }

    }
}
