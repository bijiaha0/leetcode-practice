package Amazon.LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.jiuzhang.com/solutions/longest-consecutive-sequence/
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 输入 : [100, 4, 200, 1, 3, 2]
 * 输出 : 4
 * 解释 : 这个最长的连续序列是 [1, 2, 3, 4]. 返回所求长度 4
 */

public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<>();
        for (int item : num) {
            set.add(item);
        }
        int ans = 0;
        for (int item : num) {
            if (set.contains(item)) {
                set.remove(item);
                int l = item - 1;
                int r = item + 1;
                while (set.contains(l)) {
                    set.remove(l);
                    l--;
                }
                while (set.contains(r)) {
                    set.remove(r);
                    r++;
                }
                ans = Math.max(ans, r - l - 1);
            }
        }
        return ans;
    }
}
