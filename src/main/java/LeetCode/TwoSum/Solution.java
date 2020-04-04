package LeetCode.TwoSum;
import java.util.HashMap;
import java.util.Map;
/**
 * https://leetcode.com/problems/two-sum/
 * id = 1
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=0,j = nums.length-1;
        for(;i <=j ;i++){
            if(map.containsKey(target- nums[i])){
                return new int[]{map.get(target- nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

}
