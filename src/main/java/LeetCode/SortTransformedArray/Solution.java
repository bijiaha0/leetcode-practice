package LeetCode.SortTransformedArray;
/**
 * Author: bijiaha0
 * Date: 2019-04-02
 * Time: 23:26
 * Email: clickgwas@gmail.com
 * http://www.cnblogs.com/grandyang/p/5595614.html
 * Example 1:
 * Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * Output: [3,9,15,33]
 * Example 2:
 * Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * Output: [-23,-5,1,7]
 */
public class Solution {
    int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length, i = 0, j = n - 1;
        int[] res = new int[n];
        int idx = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                res[idx--] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ? cal(nums[i++], a, b, c) : cal(nums[j--], a, b, c);
            } else {
                res[idx++] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ? cal(nums[j--], a, b, c) : cal(nums[i++], a, b, c);
            }
        }
        return res;
    }
    int cal(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
