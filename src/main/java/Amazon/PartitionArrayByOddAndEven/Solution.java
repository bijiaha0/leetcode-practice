package Amazon.PartitionArrayByOddAndEven;
/**
 * https://www.jiuzhang.com/solutions/partition-array-by-odd-and-even/
 * 原题目很简单，只需要将原数组扫描两遍，第一遍加入奇数，第二遍加入偶数，然后把答案数组覆盖原数组即可。
 * 对于challenge问题，我们需要采用双指针（two pointer）的方法，
 * 一个从头开始，一个从尾开始，头指针定位到从前到后的第一个偶数，
 * 尾指针定位到从后到前的第一个奇数，两者交换即可。直到尾指针在头之前前面。
 * 题目：分割一个整数数组，使得奇数在前偶数在后。
 */
public class Solution {
    public void partitionArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {//奇数
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {//偶数
                end--;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
