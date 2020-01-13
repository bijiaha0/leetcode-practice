package LeetCode.MergeSort;
public class Solution {
    public void sort(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
    public void merge(int[] nums, int start, int mid, int end) {
        int leftStart = start;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = end;
        int k = 0;
        int[] tmp = new int[end - start + 1];
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (nums[leftStart] <= nums[rightStart]) {
                tmp[k++] = nums[leftStart++];
            } else {
                tmp[k++] = nums[rightStart++];
            }
        }
        while (leftStart <= leftEnd) {
            tmp[k++] = nums[leftStart++];
        }
        while (rightStart <= rightEnd) {
            tmp[k++] = nums[rightStart++];
        }
        for (int i = 0; i < end - start + 1; i++) {
            nums[start + i] = tmp[i];
        }
    }
}
