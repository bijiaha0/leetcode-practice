/*
package Amazon.GuessNumberHigherOrLower;

*/
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 12:07 PM
 * Email: clickgwas@gmail.com
 *//*

public class ZigzagIterator extends GuessGame {
    */
/**
     * @param n an integer
     * @return the number you guess
     *//*

    public int guessNumber(int n) {
        // Write your code here
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }

            if (res == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
*/
