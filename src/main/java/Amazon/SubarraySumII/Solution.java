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
    public int subarraySumII(int[] A, int start, int end){
        int len = A.length;
        //prefixSum数组  ---递增
        for(int i = 1; i < len; i++){
            A[i] +=A[i-1];
        }
        int cnt =0;
        for(int i =0; i < len; i++){
            if(A[i] >= start && A[i] <= end){
                cnt ++;
            }
            int l = A[i]-end;//大于等于 A[i]-end的最小位置
            int r = A[i]- start;//小于等于 A[i]-start的最大位置-->大于等于A[i]-start+1的最小值
            cnt += find(A,len,r+1) -1 - find(A,len,l) + 1;
        }
        return cnt;
    }
}
