package Amazon.InsertInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * 往往会将区间按照左端点从小到大排个序
 * <p>
 * Author: bijiaha0
 * Date: 2019-02-23
 * Time: 2:13 AM
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/insert-interval/description
 * Input:
 * (2, 5) into [(1,2), (5,9)]
 * Output:
 * [(1,9)]
 * <p>
 * Input:
 * (3, 4) into [(1,2), (5,9)]
 * Output:
 * [(1,2), (3,4), (5,9)]
 * <p>
 * 使用 Merge Interval
 */
class Interval {

    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();

        int idx = 0;
        while (idx < intervals.size() && intervals.get(idx).start < newInterval.start) {
            idx++;
        }
        intervals.add(idx, newInterval);

        // Merge Interval
        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list
            }
        }
        return ans;
    }
}
