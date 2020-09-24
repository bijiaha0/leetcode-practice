package Amazon.MergeIntervals;

import java.util.*;

/**
 * https://www.lintcode.com/problem/merge-intervals/description
 */
/*
 * 区间左端点从小到大排个序，从左往右扫一遍
 * 不能合并---> 直接下一个
 * 能合并 ---> 就合并
 * */
class Interval {

    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals == null) {
            return ans;
        }
        intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start
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
