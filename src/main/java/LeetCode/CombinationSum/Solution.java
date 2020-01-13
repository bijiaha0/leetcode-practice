package LeetCode.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//同一个数字可以使用多次
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        helper(nums,res,new ArrayList<Integer>(),target,0);
        return res;
    }
    private void helper(int[] nums,List<List<Integer>> res,List<Integer> list,int remain,int start){
        if(remain==0){
            res.add(new ArrayList<>(list));
        }
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            if(remain-nums[i]>0){
                helper(nums,res,list,remain-nums[i],i);
            }
            list.remove(nums[i]);
        }
    }
}
