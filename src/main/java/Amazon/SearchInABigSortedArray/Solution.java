package Amazon.SearchInABigSortedArray;

/**
 * 在大数组中查找
 * https://www.jiuzhang.com/solution/search-in-a-big-sorted-array/
 */
class ArrayReader {
    public int get(int index) {
        return -1;
    }
};

public class Solution {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int index = 1;
        while (reader.get(index - 1) < target) {
            index = index * 2;//倍增的方式查找
        }
        int start = 0, end = index - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (reader.get(mid) == target) {
                end = mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
