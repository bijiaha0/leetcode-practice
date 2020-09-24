package LeetCode.GuessNumberHigherOrLower;
//猜数字

/**
 * -1代表这个数字小于你猜测的数;1代表这个数字大于你猜测的数;0代表这个数字等于你猜测的数
 */
public class Solution {

    public static int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }
            if (res >= 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (guess(l) == 0) {
            return l;
        }
        if (guess(r) == 0) {
            return r;
        }
        return -1;
    }

    public static int guess(int num) {
        if (num < 4) {
            return 1;
        } else if (num > 4) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(5));
    }
}
