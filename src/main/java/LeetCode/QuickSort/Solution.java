package LeetCode.QuickSort;
public class Solution {
    void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int index = partation(A, start, end);
        quickSort(A, start, index - 1);
        quickSort(A, index + 1, end);
    }
    int partation(int[] nums, int start, int end) {
        int piort = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= piort) end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= piort) start++;
            nums[end] = nums[start];
        }
        nums[start] = piort;
        return start;
    }
}
