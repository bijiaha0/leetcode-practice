package LeetCode.TryWithStack;
public class Solution {
    public int strap(int[] arr){
        int res = 0;
        if(arr==null||arr.length<=2){
            return res;
        }
        int left =0;
        int right= arr.length;
        int leftMax = 0;
        int rightMax = 0;
        while (left<=right){
            if(leftMax<=rightMax){
                leftMax = Math.max(leftMax,arr[left]);
                if(arr[left]<leftMax){
                    res+=leftMax-arr[left];
                }
                left++;
            }else {
                rightMax = Math.max(rightMax,arr[right]);
                if(arr[right]<rightMax){
                    res+=rightMax-arr[right];
                }
                right--;
            }
        }
        return res;
    }

}
