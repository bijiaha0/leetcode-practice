package Amazon.RemoveDuplicateNumbersInArray;
import java.util.Arrays;
/**
 * https://www.lintcode.com/problem/remove-duplicate-numbers-in-array/description
 * O(nlogn) time, O(1) extra space
 * 排序后用双指针。一个快指针一直往前走，慢指针先不动。
 * 当快指针发现它指向的数和慢指针不一样，就把该数丢给慢指针的后一个位置。
 * 慢指针++。最后返回慢指针的值+1。
 *
 * 同向双指针
 */
public class Solution1 {
    public int deduplication(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }
}
