package Amazon.TwoSum;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i, n = nums.length;
        for (i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                break;
            }
        }
        return new int[]{map.get(nums[i]), i};
    }
}
