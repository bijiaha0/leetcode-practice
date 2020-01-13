package LeetCode.ThreeSumSmaller;
public class Solution {
    public int threeSumSmaller(int[] arr,int target){
        int count = 0;
        for(int i =0; i < arr.length-2;i++){
            int start = i+1;
            int end = arr.length-1;
            while (start<end){
                if(arr[i]+arr[start]+arr[end]<target){
                    count += end-start;
                    start++;
                }else {
                    end--;
                }
            }
        }
        return count;
    }
}
