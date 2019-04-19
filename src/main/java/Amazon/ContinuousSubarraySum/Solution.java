package Amazon.ContinuousSubarraySum;
import java.util.ArrayList;
/*
*
* https://www.jiuzhang.com/solution/continuous-subarray-sum/
* */
/*
* 给定一个整数数组，请找出一个连续子数组，使得该子数组的和最大。
* 输出答案时，请分别返回第一个数字和最后一个数字的下标。（如果存在多个答案，请返回字典序最小的）
*
*
*
*
* 方法：
*   分裂
*   取反；
*   加倍。
* */
public class Solution {
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        result.add(0);

        int len = A.length;
        int start = 0, end = 0;
        int sum = 0;
        int ans = -0x7fffffff;
        for (int i = 0; i < len; i++) {
            if (sum < 0) {
                sum = A[i];
                start = end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (sum > ans) {
                ans = sum;
                result.set(0, start);
                result.set(1, end);
            }
        }
        return result;
    }
}
