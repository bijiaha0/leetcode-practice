package PlayWithAlgorithmInterview.UsingHashTable.ContainsDuplicateIII;
import java.util.TreeSet;
// 220. Contains Duplicate III
// https://leetcode.com/problems/contains-duplicate-iii/description/
// 时间复杂度: O(nlogk)
// 空间复杂度: O(k)
/*
*Given an array of integers,
* find out whether there are two distinct indices i and j
* in the array such that the absolute difference
* between nums[i] and nums[j] is at most t and
* the absolute difference between i and j is at most k.
* */
//滑动窗口+查找表
/*
* java.util.TreeSet.floor()方法和java.util.TreeSet.ceiling()方法
* floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
* ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
* */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Long> record = new TreeSet<Long>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(record.ceiling((long)nums[i] - (long)t) != null &&
                    record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t)
            return true;
            record.add((long)nums[i]);
            if(record.size() == k + 1)
                record.remove((long)nums[i-k]);
        }
        return false;
    }
    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }
    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        printBool((new Solution()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
