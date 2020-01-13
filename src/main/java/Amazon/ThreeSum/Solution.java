package Amazon.ThreeSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i, n = nums.length, low, high;
        Arrays.sort(nums);
        if (n == 0) {
            return res;
        }
        for (i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            low = i + 1;
            high = n - 1;
            while (low < high) {
                if (nums[low] + nums[high] == -nums[i]) {
                    res.add(Arrays.asList(nums[low], nums[high], nums[i]));
                    while (low < high && nums[low] == nums[low + 1] && nums[high] == nums[high - 1]) {
                        low++;
                        high--;
                    }
                    low++;
                    high--;
                } else if (nums[low] + nums[high] > -nums[i]) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return res;
    }


}
