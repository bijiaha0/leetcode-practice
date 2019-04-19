package PlayWithAlgorithmInterview.UsingHashTable.ContainsDuplicateII;
import java.util.HashSet;
// 219. Contains Duplicate II
// https://leetcode.com/problems/contains-duplicate-ii/description/
// 时间复杂度: O(n)
// 空间复杂度: O(k)
/*
* Given an array of integers and an integer k,
* find out whether there are two distinct indices i and j
* in the array such that nums[i] = nums[j] and
* the absolute difference between i and j is at most k.
* */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1)
            return false;
        if(k <= 0)
            return false;
        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length; i ++){
            if(record.contains(nums[i]))
                return true;
            record.add(nums[i]);
            //保持最多有k个元素
            if(record.size() == k + 1)
                record.remove(nums[i-k]);
        }
        return false;
    }
    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int k = 1;
        printBool((new Solution()).containsNearbyDuplicate(nums, k));
    }
}
