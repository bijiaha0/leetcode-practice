package Amazon.SubarraySum;
/*
* https://www.lintcode.com/problem/subarray-sum/description
* */
import java.util.ArrayList;
import java.util.HashMap;
/*
* 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
* */
/*
某一段[l, r]的和为0， 则其对应presum[l-1] = presum[r].
prefixSum 为数组前缀和。只要保存每个前缀和，找是否有相同的前缀和即可。
时间复杂度O(n)
* */
public class Solution {
    public ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;

        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }
            map.put(sum, i);
        }
        return ans;
    }
}
