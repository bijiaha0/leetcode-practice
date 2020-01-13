package Amazon.KthLargestElement;
/*
 * 寻找第k大元素
 * 时间复杂度是O(n)   等比数列
 * 第一大是length-1
 * 第二大是length-2
 * 第k大是length-k
 * */
public class Solution {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
    public int helper(int[] nums, int l, int r, int k) {
        if (l >= r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position == k) {
            return nums[position];
        } else if (position < k) {
            return helper(nums, position + 1, r, k);
        } else {
            return helper(nums, l, position - 1, k);
        }
    }
    //快排模板
    public int partition(int[] nums, int l, int r) {
        //初始化左右指针
        int left = l, right = r;
        int pivot = nums[left];
        //进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        //返还pivot点到数据里面
        nums[left] = pivot;
        return left;
    }
}
