package Amazon.LongestConsecutiveSequence;
import java.util.HashSet;
import java.util.Set;
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
