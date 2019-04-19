package Amazon.MaximumSubarrayII;
import java.util.ArrayList;
/**
 * https://www.jiuzhang.com/solution/maximum-subarray-ii/
 * 这个题的思路是，因为 两个subarray 一定不重叠
 * 所以必定存在一条分割线
 * 分开这两个 subarrays
 * 所以 最后的部分里：
 *   max = Integer.MIN_VALUE;
 *         for(int i = 0; i < size - 1; i++){
 *             max = Math.max(max, left[i] + right[i + 1]);
 *         }
 *         return max;
 * 这里是在枚举 这条分割线的位置
 * 然后 left[] 和 right[] 里分别存的是，某个位置往左的 maximum subarray 和往右的 maximum subarray
 */
public class Solution {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {

        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        //从左往右做一遍
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        //从右往左做一遍
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        //分割数组成两个部分
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}
