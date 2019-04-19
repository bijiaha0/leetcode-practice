package Amazon.FollowUp3SumClosest;

import java.util.Arrays;

/**
 * Author: bijiaha0
 * Date: 2019-03-09
 * Time: 13:40
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solutions/3sum-closest/
 */
public class Solution {
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }

        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return bestSum;
    }
}
