package Amazon.LongestConsecutiveSequence;
import java.util.HashSet;
import java.util.Set;
/**
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 10:45 AM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/longest-consecutive-sequence/description
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 * 一种简单的方法是对每个数字，从左往右搜索一下，看最长能有多长
 *
 * 是否可以跳出排序后扫描的思维定式，以每个元素作为突破点
 *
 * Hash可以在O(1)的时间内确定一个元素是否存在。
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
