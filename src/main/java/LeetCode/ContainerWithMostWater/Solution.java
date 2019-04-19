package LeetCode.ContainerWithMostWater;

/**
 * Author: bijiaha0
 * Date: 2019-04-02
 * Time: 22:53
 * Email: clickgwas@gmail.com
 * https://leetcode.com/problems/container-with-most-water/solution/
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])//谁小挪谁
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
