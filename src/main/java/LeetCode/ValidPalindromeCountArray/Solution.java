package LeetCode.ValidPalindromeCountArray;
public class Solution {
    public static void valid(int[] arr,int[] count,int startIndex){
        if(arr==null||arr.length==0){
            return;
        }
        if(!isOr(arr,startIndex)){
            arr[startIndex+1]+=arr[startIndex];
            count[0]++;
            valid(arr,count,startIndex+1);
        }
        return;
    }
    public static boolean isOr(int[] arr,int startIndex){
        int start = startIndex;
        int end = arr.length-1;
        while (start<=end){
            if(arr[start++]!=arr[end--]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,9};
        int[] count = new int[1];
        valid(arr, count, 0);
        System.out.println(count[0]);
    }
}
