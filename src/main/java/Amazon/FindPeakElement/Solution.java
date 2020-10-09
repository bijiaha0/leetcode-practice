package Amazon.FindPeakElement;

public class Solution {

    /**
     * https://leetcode.com/problems/find-peak-element/
     * <p>
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     */
    public int findPeakElement(int[] num) {

        if (num == null || num.length < 2) {
            return -1;
        }

        if (num[0] > num[1]) {
            return num[0];
        }

        if (num[num.length - 1] > num[num.length - 2]) {
            return num[num.length - 1];
        }

        int start = 1, end = num.length - 2;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[mid - 1]) {
                end = mid - 1;
            } else if (num[mid] < num[mid + 1]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }

}
