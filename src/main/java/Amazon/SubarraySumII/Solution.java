package Amazon.SubarraySumII;
/*
*https://github.com/jiadaizhao/LintCode/blob/master/0404-Subarray%20Sum%20II/0404-Subarray%20Sum%20II.cpp
* Given an integer array, find a subarray where the sum of numbers is in a given interval.
* Your code should return the number of possible answers. (The element in the array should be positive)
 * */
/*
*
* 给定一个正整数数组及一个区间，找到一个子数组，使得其数字的总和在给定区间范围内。请返回所有可能答案的数量。
 * */
public class Solution {
    //二分法模板-----寻找有序数组，在value大小的索引位置
    int find(int[] A, int len, int value){
        if(A[len-1] < value){
            return len;
        }
        int l =0, r =len-1, ans =0;
        while(l <= r){
            int mid = (l+r)/2;
            if(value <= A[mid]){
                ans =mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }
    /*
    * sum[i,j] 计算从i位置到j位置的和;   j位置减去i-1位置
    * prefix[j+1] - prefix[i];
    *
    *          start <= prefix[j+1] - prefix[i]  <=  end
    *
    *            prefix[j+1] - end <= prefix[i]  <=   prefix[j+1] - start
    *
    * */
    public int subarraySumII(int[] A, int start, int end){
        int len = A.length;
        //prefixSum数组  ---递增
        for(int i = 1; i < len; i++){
            A[i] +=A[i-1];
        }
        int cnt =0;
        for(int i =0; i < len; i++){
            /*
            * 当A[i] < start的时候，
            * 当A[i] >= start && A[i] <= end的时候,
            * 当A[i] >= end的时候,
            * */
            if(A[i] >= start && A[i] <= end){
                cnt ++;
            }
            int l = A[i]-end;//求小于等于end的最大值的下标；-----大于等于 A[i]-end的最小位置
            int r = A[i]- start;//求大于等于start的最小值的下标。-----小于于等于 A[i]-start的最大位置
            cnt += find(A,len,r+1) -1 - find(A,len,l) + 1;
        }
        return cnt;
    }
}
/*
因为题目要求子段和在区间 [start, end] 之间，注意此时的A数组已经发生变化，A[i]记录的是前i个数的前缀和。
那么任何一个子段的和即使两个前缀值的差，
假设我们让A[i]作为被减数，也就是说start <= A[i] - value <= end
得出 value <= A[i] - start 且 A[i] - end <= value
find(A, len, r+1) 就是找出 value <= A[i] - start 这个条件满足要求的。
find(A, len, l) 就是找出 A[i] - end <= value 不满足这个要求的，相减就是剩下满足要求的value的个数。
* */
