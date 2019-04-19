package tju.recursion;
/**
 * Author: bijiaha0
 * Date: 2018-09-26
 * Time: 下午12:11
 * Email: clickgwas@gmail.com
 */
//暴力递归:
// 1，把问题转化为规模缩小了的同类问题的子问题
// 2，有明确的不需要继续进行递归的条件(base case)
// 3，有当得到了子问题的结果之后的决策过程
// 4，不记录每一个子问题的解
public class getMin {
    public static int getMin(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        int mid = (L+R)/2;
        int leftMin = getMin(arr,L,mid);
        int rightMin = getMin(arr,mid+1,R);
        return Math.min(leftMin,rightMin);
    }
}
