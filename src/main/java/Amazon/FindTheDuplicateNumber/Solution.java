package Amazon.FindTheDuplicateNumber;
/*
*https://www.lintcode.com/problem/find-the-duplicate-number/solution
* 什么是快慢指针算法？
从起点出发，慢指针走一步，快指针走两步。因为有环，所以一定会相遇。
相遇之后，把其中一根指针拉回起点，重新走，这回快慢指针都各走一步。他们仍然会再次相遇，且相遇点为环的入口。
* */
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1)
            return -1;

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

}
